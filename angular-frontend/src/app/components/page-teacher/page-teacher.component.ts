import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';
import {TokenStorageService} from '../../services/token/token-storage.service';

@Component({
  selector: 'app-page-teacher',
  templateUrl: './page-teacher.component.html',
  styleUrls: ['./page-teacher.component.css']
})
export class PageTeacherComponent implements OnInit {

  id?: number;

  constructor(private router: Router,
              private tokenStorageService: TokenStorageService) {
    this.id = tokenStorageService.getUser().id;
  }

  ngOnInit(): void {
  }

  getMaterialsByAuthor(){
    this.router.navigate([`materials/author/${this.id}`]);
  }

  getTasksByAuthor(){
    this.router.navigate([`tasks/user/${this.id}`]);
  }
}
