import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Material} from '../../models/material/material';

const API_URL = 'http://localhost:8081/materials';

@Injectable({
  providedIn: 'root'
})
export class MaterialService {

  constructor(private httpClient: HttpClient) { }

  getAllByDiscipline(discipline: number): Observable<Material[]>{
    return this.httpClient.get<Material[]>(`${API_URL}/discipline/${discipline}`);
  }
}
