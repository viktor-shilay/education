import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Discipline} from '../../models/discipline/discipline';

const API_URL = 'http://localhost:8081/';

@Injectable({
  providedIn: 'root'
})
export class DisciplineService {

  constructor(private httpClient: HttpClient) { }

  getAll(page: number, size: number): Observable<Discipline[]>{
    return this.httpClient.get<Discipline[]>(`${API_URL}disciplines/?page=${page}&size=${size}`);
  }
}
