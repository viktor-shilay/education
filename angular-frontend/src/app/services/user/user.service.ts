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
    return this.httpClient.get<User[]>(`${API_URL}`);
  }

  get(id: number): Observable<User> {
    return this.httpClient.get<User>(`${API_URL}/${id}`);
  }

  create(data: any): Observable<any>{
    return this.httpClient.post(`${API_URL}`, data);
  }

  update(id: any, data: any): Observable<any>{
    return this.httpClient.put(`${API_URL}/${id}`, data);
  }

  delete(id: any): Observable<any>{
    return this.httpClient.delete(`${API_URL}/${id}`);
  }

  findByName(name: string): Observable<User[]>{
    return this.httpClient.get<User[]>(`${API_URL}?name=${name}`);
  }


  getPublicContent(): Observable<any> {
    return this.httpClient.get(API_URL + 'all', { responseType: 'text' });
  }

  getTeacherPage(): Observable<any> {
    return this.httpClient.get(API_URL + 'teacher', { responseType: 'text' });
  }

  getStudentPage(): Observable<any> {
    return this.httpClient.get(API_URL + 'student', { responseType: 'text' });
  }

  getProfessorPage(): Observable<any> {
    return this.httpClient.get(API_URL + 'professor', { responseType: 'text' });
  }

  getAdminPage(): Observable<any> {
    return this.httpClient.get(API_URL + 'admin', { responseType: 'text' });
  }
}
