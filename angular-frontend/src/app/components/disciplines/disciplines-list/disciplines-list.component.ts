import { Component, OnInit } from '@angular/core';
import {DisciplineService} from '../../../services/discipline/discipline.service';
import {Discipline} from '../../../models/discipline/discipline';
import {TokenStorageService} from '../../../services/token/token-storage.service';
import {MaterialService} from '../../../services/material/material.service';
import {Material} from '../../../models/material/material';

@Component({
  selector: 'app-disciplines-list',
  templateUrl: './disciplines-list.component.html',
  styleUrls: ['./disciplines-list.component.css']
})
export class DisciplinesListComponent implements OnInit {

  discipline: Discipline = new Discipline();
  disciplines?: Discipline[];
  materials?: Material[];
  tableMode?: boolean;
  create?: boolean;
  materialsTable?: boolean;

  constructor(private disciplineService: DisciplineService,
              private materialService: MaterialService,
              private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.tableMode = true;
    this.create = false;
    this.loadDisciplines();
  }

  loadDisciplines(){
    this.disciplineService.getAll().subscribe(
      data => {
        this.disciplines = data;
        console.log(this.disciplines);
      }, error => {
        console.log(error);
      }
    );
  }

  save(){
    this.discipline.userId = this.tokenStorageService.getUser().id;
    console.log(this.discipline.userId);
    this.disciplineService.create(this.discipline).subscribe(
      data => {
        this.loadDisciplines();
      }
    );
    this.cancel();
  }

  editDiscipline(d: Discipline){
    this.discipline = d;
    if (d.userId !== this.tokenStorageService.getUser().id){
      alert('access denied');
      this.cancel();
    }
  }

  cancel(){
    this.discipline = new Discipline();
    this.tableMode = true;
    this.create = false;
  }

  add(){
    this.cancel();
    this.tableMode = false;
    this.create = true;
  }

  showMaterials(disciplineId: number){
    this.tableMode = false;
    this.create = false;
    this.materialsTable = true;
    console.log(disciplineId);
    this.materialService.getAllByDiscipline(disciplineId).subscribe(
      data => {
        this.materials = data;
        console.log(data);
      }, error => {
        console.log(error);
      }
    );
  }
}
