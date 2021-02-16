import { Component, OnInit } from '@angular/core';
import {Material} from '../../../models/material/material';
import {MaterialService} from '../../../services/material/material.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-materials-list',
  templateUrl: './materials-list.component.html',
  styleUrls: ['./materials-list.component.css']
})
export class MaterialsListComponent implements OnInit {

  userId: number;
  materials?: Material[];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private materialService: MaterialService) {
    this.userId = route.snapshot.params.authorId;
    console.log(route.snapshot.params.authorId);
  }

  ngOnInit(): void {
    this.loadMaterialsByAuthor(this.userId);
  }

  loadMaterialsByAuthor(userId: number){
    this.materialService.getAllByAuthor(userId).subscribe(
      data => {
        this.materials = data;
        console.log(data);
      }, error => {
        console.log(error);
      }
    );
  }

  addMaterial(){
    this.router.navigate(['materials/add']);
  }
}
