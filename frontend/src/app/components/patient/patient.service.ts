import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient.model';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private baseUrl: string = "http://localhost:8080/patients"

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Patient[]> {
    return this.httpClient.get<Patient[]>(this.baseUrl)
  }

  deleteById(id: string): Observable<void> {
    const url: string = `${this.baseUrl}/${id}`
    console.log(url)
    return this.httpClient.delete<void>(url)
  }

}
