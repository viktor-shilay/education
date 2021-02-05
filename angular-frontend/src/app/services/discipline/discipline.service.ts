import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Discipline} from '../../models/discipline/discipline';

const API_URL = 'http://localhost:8081/disciplines';

@Injectable({
  providedIn: 'root'
})
export class DisciplineService {

  constructor(private httpClient: HttpClient) { }

  /*getAll(page: number, size: number): Observable<Discipline[]>{
    return this.httpClient.get<Discipline[]>(`${API_URL}?page=${page}&size=${size}`);
  }*/

  getAll(): Observable<Discipline[]>{
    return this.httpClient.get<Discipline[]>(`${API_URL}`);
  }

  getAllByUser(id: number | undefined): Observable<Discipline[]>{
    return this.httpClient.get<Discipline[]>(`${API_URL}/user/${id}`);
  }

  create(discipline: Discipline): Observable<Discipline[]>{
    return this.httpClient.post<Discipline[]>(`${API_URL}`, discipline);
  }

  update(id: number, discipline: Discipline): Observable<Discipline[]>{
    return this.httpClient.put<Discipline[]>(`${API_URL}/${id}`, discipline);
  }




  prevPage(page: number, size: number): Observable<Discipline[]>{
    return this.httpClient.get<Discipline[]>(`${API_URL}?page=${page - 1}&size=${size}`);
  }

  nextPage(page: number, size: number): Observable<Discipline[]>{
    return this.httpClient.get<Discipline[]>(`${API_URL}?page=${page + 1}&size=${size}`);
  }

}
