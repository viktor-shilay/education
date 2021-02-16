import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Task} from '../../models/task/task';
import {HttpClient} from '@angular/common/http';

const API_URL = 'http://localhost:8081/tasks';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private httpClient: HttpClient) { }

  getAllByUser(id?: number): Observable<Task[]>{
    return this.httpClient.get<Task[]>(`${API_URL}/user/${id}`);
  }

}
