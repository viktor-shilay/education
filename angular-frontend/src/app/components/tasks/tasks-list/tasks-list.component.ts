import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TaskService} from '../../../services/task/task.service';
import {Task} from '../../../models/task/task';

@Component({
  selector: 'app-task',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  userId: number;
  tasks?: Task[];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private taskService: TaskService) {
    this.userId = route.snapshot.params.userId;
    console.log(this.userId);
  }

  ngOnInit(): void {
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
}
