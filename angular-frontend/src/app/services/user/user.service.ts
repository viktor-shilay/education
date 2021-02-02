import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../../models/user/user';
import {Observable} from 'rxjs';

const API_URL = 'http://localhost:8081/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${API_URL}users`);
  }

  get(id: number): Observable<User> {
    return this.httpClient.get<User>(`${API_URL}users/${id}`);
  }

  create(data: any): Observable<any>{
    return this.httpClient.post(`${API_URL}users`, data);
  }

  update(id: any, data: any): Observable<any>{
    return this.httpClient.put(`${API_URL}${id}users`, data);
  }

  delete(id: any): Observable<any>{
    return this.httpClient.delete(`${API_URL}users/${id}`);
  }

  findByName(name: string): Observable<User[]>{
    return this.httpClient.get<User[]>(`${API_URL}users?name=${name}`);
  }


  getPublicContent(): Observable<any> {
    return this.httpClient.get(API_URL + 'all');
  }

  getTeacherPage(): Observable<any> {
    return this.httpClient.get(API_URL + 'teacher');
  }

  getStudentPage(): Observable<any> {
    return this.httpClient.get(API_URL + 'student');
  }

  getProfessorPage(): Observable<any> {
    return this.httpClient.get(API_URL + 'professor');
  }

  getAdminPage(): Observable<any> {
    return this.httpClient.get(API_URL + 'admin');
  }
}
