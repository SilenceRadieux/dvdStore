
import { DvdServiceService } from '../services/dvd-service.service';
import { GenreEnum } from './../utils/enum/GenreEnum';
import { Component, OnInit } from '@angular/core';

export interface Dvd {
  name: string,
  genre: GenreEnum,
  imgPath: string
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  

}
