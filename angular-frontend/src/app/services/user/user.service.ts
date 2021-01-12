import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../../models/user/user';
import {Observable} from 'rxjs';

const baseUrl = 'http://localhost:8080/users';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${baseUrl}`);
  }

  get(id: number): Observable<User> {
    return this.httpClient.get<User>(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any>{
    return this.httpClient.post(`${baseUrl}`, data);
  }

  update(id: any, data: any): Observable<any>{
    return this.httpClient.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any>{
    return this.httpClient.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any>{
    return this.httpClient.delete(`${baseUrl}`);
  }

  findByLastName(lastName: string): Observable<User[]>{
    return this.httpClient.get<User[]>(`${baseUrl}?lastName=${lastName}`);
  }
}
