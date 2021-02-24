import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TaskService} from '../../../services/task/task.service';
import {Task} from '../../../models/task/task';
import {UserTasks} from '../../../models/userTasks/user-tasks';
import {UserTasksService} from '../../../services/userTasks/user-tasks.service';

@Component({
  selector: 'app-task',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  userId: number;
  tasks?: Task[];
  userTasks: UserTasks;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private taskService: TaskService,
              private userTasksService: UserTasksService) {
    this.userId = route.snapshot.params.userId;
    console.log(this.userId);
  }

  ngOnInit(): void {
    this.userTasks = new UserTasks();
    this.retrieveTasksByUser(this.userId);
  }

  retrieveTasksByUser(userId: number){
    this.taskService.getAllByUser(userId).subscribe(
      data => {
        this.tasks = data;
        console.log(this.tasks);
      }, error => {
        console.log(error);
      }
    );
  }

  addTask(){
    this.router.navigate([`tasks/add`]);
  }

  send(task: Task, grade: string){
    this.userTasks.grade = grade;
    this.userTasks.status = 'Assessed';
    this.userTasks.userId = task.userId;
    this.userTasks.taskId = task.id;
    this.userTasks.studentId = task.studentId;
    console.log(this.userTasks);
    this.userTasksService.update(this.userTasks).subscribe(
      data => {
        console.log(data);
      }, error => {
        console.log(error);
      }
    );
    this.ngOnInit();
  }
}
