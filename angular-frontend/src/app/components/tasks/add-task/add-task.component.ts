import { Component, OnInit } from '@angular/core';
import {DisciplineService} from '../../../services/discipline/discipline.service';
import {Discipline} from '../../../models/discipline/discipline';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  disciplines: Discipline[];
  disciplineName: string;

  constructor(private disciplineService: DisciplineService) { }

  ngOnInit(): void {
    this.getAllDisciplines();
  }

  getAllDisciplines(){
    this.disciplineService.getAll().subscribe(
      data => {
        this.disciplines = data;
        console.log(data);
      }, error => {
        console.log(error);
      }
    );
  }
}
