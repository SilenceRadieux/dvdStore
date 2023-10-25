import { Component, OnInit, Input } from '@angular/core';
import { DvdServiceService } from '../services/dvd-service.service';
import { Dvd } from '../interface/dvd';


@Component({
  selector: 'app-dvd',
  templateUrl: './dvd.component.html',
  styleUrls: ['./dvd.component.scss']
})
export class DvdComponent implements OnInit {

@Input () dvds: Dvd[] = [];

  constructor() {}
  ngOnInit() {}

}
