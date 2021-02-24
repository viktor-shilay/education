import { Component, OnInit } from '@angular/core';
import {DisciplineService} from '../../../services/discipline/discipline.service';
import {Discipline} from '../../../models/discipline/discipline';
import {MaterialService} from '../../../services/material/material.service';
import {Material} from '../../../models/material/material';
import {TaskService} from '../../../services/task/task.service';
import {Task} from '../../../models/task/task';
import {ActivatedRoute, Router} from '@angular/router';
import {TokenStorageService} from '../../../services/token/token-storage.service';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  disciplines: Discipline[];
  selectedDiscipline: Discipline;
  selectedMaterial: Material;
  materials: Material[];
  task: Task;
  dueDate: string;
  description: string;
  group: string;

  constructor(private disciplineService: DisciplineService,
              private materialService: MaterialService,
              private taskService: TaskService,
              private router: Router,
              private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.getAllDisciplines();
    this.task = new Task();
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

  getMaterialsByDiscipline(){
    this.materialService.getAllByDiscipline(this.selectedDiscipline.id).subscribe(
      data => {
        this.materials = data;
        console.log(data);
      }, error => {
        console.log(error);
      }
    );
  }

  onSubmit(){
    this.task.discipline = this.selectedDiscipline.shortName;
    this.task.materialName = this.selectedMaterial.materialName;
    this.task.group = this.group;
    this.task.description = this.description;
    this.task.dueDate = this.dueDate;
    this.task.userId = this.tokenStorageService.getUser().id;
    this.taskService.create(this.task).subscribe(
      response => {
        console.log(response);
      }, error => {
        console.log(error);
      }
    );
    this.router.navigate([`tasks/user/${this.tokenStorageService.getUser().id}`]);
  }
}
