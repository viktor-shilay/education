import { Component, OnInit } from '@angular/core';
import {DisciplineService} from '../../services/discipline/discipline.service';
import {Discipline} from '../../models/discipline/discipline';

@Component({
  selector: 'app-page-professor',
  templateUrl: './page-professor.component.html',
  styleUrls: ['./page-professor.component.css']
})
export class PageProfessorComponent implements OnInit {
  disciplines?: Discipline[];
  page = 1;
  size = 10;
  constructor(private disciplineService: DisciplineService) { }

  ngOnInit(): void {
    this.retrieveDisciplines();
  }

  retrieveDisciplines(){
    this.disciplineService.getAll(this.page, this.size).subscribe(
      data => {
        // @ts-ignore
        this.disciplines = data.content;
      }
    );
  }
}
