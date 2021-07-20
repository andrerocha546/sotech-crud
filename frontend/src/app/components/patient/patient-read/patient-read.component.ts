import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient.model';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-patient-read',
  templateUrl: './patient-read.component.html',
  styleUrls: ['./patient-read.component.css']
})
export class PatientReadComponent implements OnInit {

  private patients: Array<Patient> = new Array;

  constructor(private patientService: PatientService) { }

  ngOnInit(): void {
    this.patientService.findAll().subscribe(patients => {
      this.patients = patients
      console.log(this.patients)
    })
  }

}
