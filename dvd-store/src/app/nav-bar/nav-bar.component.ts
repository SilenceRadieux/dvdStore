import { Component } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})

export class NavBarComponent {

  searchText = '';
  handleSearchInput = (event: any) => {
    this.searchText = event?.target.value
  }

  handleButtonSearchClick = () => {
    console.log(this.searchText)
  }
  
}