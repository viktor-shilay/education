import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserTasks} from '../../models/userTasks/user-tasks';
import {Observable} from 'rxjs';

const API_URL = 'http://localhost:8081/users-tasks';

@Injectable({
  providedIn: 'root'
})
export class UserTasksService {

  constructor(private httpClient: HttpClient) { }

  update(userTasks: UserTasks): Observable<UserTasks[]>{
    return this.httpClient.put<UserTasks[]>(`${API_URL}`, userTasks);
  }
}
