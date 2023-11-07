import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.scss']
})

export class SideBarComponent {

@Output() dataEvent = new EventEmitter<String>();

  constructor() {}

  sendGenre(genre: string) {
    this.dataEvent.emit(genre);
  }



}
