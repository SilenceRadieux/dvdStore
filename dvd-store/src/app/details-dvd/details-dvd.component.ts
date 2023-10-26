import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DvdServiceService } from '../services/dvd-service.service';
import { Dvd } from '../interface/dvd';

@Component({
  selector: 'app-details-dvd',
  templateUrl: './details-dvd.component.html',
  styleUrls: ['./details-dvd.component.scss']
})

export class DetailsDvdComponent implements OnInit {
id=this.route.snapshot.params['id'];

dvd: Dvd;

constructor(private dvdApi: DvdServiceService, private route: ActivatedRoute) {
  this.dvd = {} as Dvd;
}


ngOnInit() {
  this.dvdApi.getDvdById(this.id)
    .then(res => {
      this.dvd = res
    })
    .catch((error) => {
      console.error(error.message)
    });
}

public addCartDvd(){
  this.dvdApi.addCartDvd(this.dvd);
}

}


