import { Component, OnInit } from '@angular/core';
import {User} from '../../../models/user/user';
import {Material} from '../../../models/material/material';
import {MaterialService} from '../../../services/material/material.service';
import {TokenStorageService} from '../../../services/token/token-storage.service';

@Component({
  selector: 'app-add-material',
  templateUrl: './add-material.component.html',
  styleUrls: ['./add-material.component.css']
})
export class AddMaterialComponent implements OnInit {

  material: Material = {
    materialName: '',
    type: '',
    description: '',
    author: 0,
    discipline: ''
  };
  submitted = false;

  constructor(private materialService: MaterialService,
              private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
  }

  saveMaterial(): void {
    const data = {
      materialName: this.material.materialName,
      type: this.material.type,
      description: this.material.description,
      author: this.tokenStorageService.getUser().id,
      discipline: this.material.discipline
    };

    this.materialService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newMaterial(): void {
    this.submitted = false;
    this.material = {
      materialName: '',
      type: '',
      description: '',
      author: 0
    };
  }

}
