import { Component, OnInit } from '@angular/core';
import { DvdServiceService } from '../services/dvd-service.service';
import { Dvd } from '../interface/dvd';
import { ClientServiceService } from '../services/client-service.service';
import { Client } from '../interface/client';
import { SaleServiceService } from '../services/sale-service.service';
import { Sale } from '../interface/sale';
import { MatDialog } from '@angular/material/dialog';
import { EditDvdComponent } from '../edit-dvd/edit-dvd.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

isDvdTableVisible = false;
isClientTableVisible = false;
isSaleTableVisible = false;

dvds: Dvd[] = [];
clients: Client[] = [];
sales: Sale[] = [];

  constructor(private dvdApi: DvdServiceService, private clientApi: ClientServiceService,
              private saleApi: SaleServiceService, private dialog: MatDialog) {}

  ngOnInit() {
  this.dvdApi.getAllDvds()
      .then(res => {
        this.dvds = res
      })
      .catch((error) => {
        console.error(error.message)
      });

  this.clientApi.getAllClients()
      .then(res => {
        this.clients = res
      })
      .catch((error) => {
        console.error(error.message)
      });

  this.saleApi.getAllSales()
      .then(res => {
        this.sales = res
      })
      .catch((error) => {
        console.error(error.message)
      });
  }


  openEditModal(dvd: Dvd) {
    const dialogRef = this.dialog.open(EditDvdComponent, {
      data: dvd
    });
  }

  getDvd() {

    this.isDvdTableVisible = true;
    this.isClientTableVisible = false;
    this.isSaleTableVisible = false;
  }

  getClient() {
    this.isClientTableVisible = true;
    this.isDvdTableVisible = false;
    this.isSaleTableVisible = false;
  }

  getSale() {
    this.isSaleTableVisible = true;
    this.isDvdTableVisible = false;
    this.isClientTableVisible = false;
  }

}
