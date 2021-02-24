import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user/user.service';
import {TaskService} from '../../services/task/task.service';
import {TokenStorageService} from '../../services/token/token-storage.service';
import {Task} from '../../models/task/task';
import {Router} from '@angular/router';
import {UserTasksService} from '../../services/userTasks/user-tasks.service';
import {UserTasks} from '../../models/userTasks/user-tasks';
import {User} from '../../models/user/user';

@Component({
  selector: 'app-page-student',
  templateUrl: './page-student.component.html',
  styleUrls: ['./page-student.component.css']
})
export class PageStudentComponent implements OnInit {

  tasks?: Task[];
  userTasks: UserTasks;
  studentId?: number;

  constructor(private taskService: TaskService,
              private userTasksService: UserTasksService,
              private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.userTasks = new UserTasks();
    this.studentId = this.tokenStorageService.getUser().id;
    this.retrieveTasks();
  }

  retrieveTasks(){
    this.taskService.getAllByStudent(this.studentId).subscribe(
      data => {
        this.tasks = data;
        console.log(this.tasks);
      }, error => {
        console.log(error);
      }
    );
  }

  update(task: Task){
    task.status = 'Ready for review';
    this.userTasks.grade = task.grade;
    this.userTasks.status = task.status;
    this.userTasks.userId = task.userId;
    this.userTasks.taskId = task.id;
    this.userTasks.studentId = task.studentId;
    console.log(this.userTasks);
    this.userTasksService.update(this.userTasks).subscribe(
      response => {
        console.log(response);
      }, error => {
        console.log(error);
      }
    );
  }
}
