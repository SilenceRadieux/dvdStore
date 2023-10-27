import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatDialogRef } from '@angular/material/dialog';
import { DvdServiceService } from '../services/dvd-service.service';
import { Dvd } from '../interface/dvd';

@Component({
  selector: 'app-edit-dvd',
  templateUrl: './edit-dvd.component.html',
  styleUrls: ['./edit-dvd.component.scss']
})
export class EditDvdComponent implements OnInit {

constructor(@Inject(MAT_DIALOG_DATA) public data: any, public dialogRef: MatDialogRef<EditDvdComponent>,
            private dvdService: DvdServiceService) {}
  dvd: Dvd= {
    id : 0,
    directedBy : "",
    duration : 0,
    cover : "",
    genre : "",
    isan : "",
    quantity : 0,
    releaseDate: "",
    synopsis : "",
    name : "",
    price : 0
  }
  ngOnInit() {
    this.dvd = this.data
  }

  /* onOverlayClick() {
    this.dialogRef.close();
  } */

  updateDvd(){
    this.dvdService.updateDvd(this.dvd)
  }

}
