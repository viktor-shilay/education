import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const AUTH_API = 'http://localhost:8081/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  login(email: string, password: string): Observable<any> {
    return this.httpClient.post(AUTH_API + 'login', {
      email,
      password
    }, httpOptions);
  }

  register(firstName: string, lastName: string, email: string, password: string): Observable<any> {
    return this.httpClient.post(AUTH_API + 'register', {
      firstName,
      lastName,
      email,
      password
    }, httpOptions);
  }
}
