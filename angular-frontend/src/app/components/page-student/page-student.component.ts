import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user/user.service';
import {TaskService} from '../../services/task/task.service';
import {TokenStorageService} from '../../services/token/token-storage.service';
import {Task} from '../../models/task/task';
import {Router} from '@angular/router';

@Component({
  selector: 'app-page-student',
  templateUrl: './page-student.component.html',
  styleUrls: ['./page-student.component.css']
})
export class PageStudentComponent implements OnInit {

  tasks?: Task[];
  userId?: number;

  constructor(private taskService: TaskService,
              private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.userId = this.tokenStorageService.getUser().id;
    this.retrieveTasks();
  }

  retrieveTasks(){
    this.taskService.getAllByUser(this.userId).subscribe(
      data => {
        this.tasks = data;
        console.log(this.tasks);
      }, error => {
        console.log(error);
      }
    );
  }
}
