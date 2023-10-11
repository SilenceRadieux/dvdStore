import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.scss']
})

export class SideBarComponent implements OnInit {

  genreFilter: string = '';
  dvds: any = [];
  dvdToShow: any = [];

  constructor() {}

  handleGenreClickButton(genre: string) {
  this.dvdToShow = this.dvds.filter((value: { genre: string; }) => {
    return value.genre === genre;
  });
  }

  ngOnInit() {
    this.dvdToShow = this.dvds;
  }
}