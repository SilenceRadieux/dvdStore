
import { DvdServiceService } from '../services/dvd-service.service';
import { GenreEnum } from './../utils/enum/GenreEnum';
import { Component, OnInit } from '@angular/core';
import { Dvd } from '../interface/dvd';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

genre: String = '';
dvds: Dvd[] = [];
filteredDvds: Dvd[] = [];

constructor(private dvdApi: DvdServiceService) {}

ngOnInit() {
  this.dvdApi.getAllDvds()
    .then(res => {
      this.dvds = res
      this.filteredDvds = this.dvds
    })
    .catch((error) => {
      console.error(error.message)
    });
}

getGenre(genre: String) {
  this.genre = genre;
  this.filteredDvdsByGenre();
}

filteredDvdsByGenre() {
  if (this.genre === 'all') {
    this.filteredDvds = this.dvds;
  } else {
    this.genre = this.genre.toString();
    this.filteredDvds = this.dvds.filter(dvd => {
      const genres = dvd.genre.split('|').map(genre => genre.trim());
      return genres.includes(this.genre as string);
    });
  }
}



}
