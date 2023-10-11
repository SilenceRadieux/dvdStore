import { Component, OnInit } from '@angular/core';
import { DvdServiceService } from '../services/dvd-service.service';
import { Dvd } from '../interface/dvd';


@Component({
  selector: 'app-dvd',
  templateUrl: './dvd.component.html',
  styleUrls: ['./dvd.component.scss']
})
export class DvdComponent implements OnInit {
  dvds: Dvd[] = []
  errorMessage: string = ''
  constructor(private dvdApi: DvdServiceService) {}
  ngOnInit() {
    this.dvdApi.getAllDvds()
      .then(res => {
        this.dvds = res
      })
      .catch((error) => {
        console.error(error.message)
        this.errorMessage = error
      });
  }  
  }
