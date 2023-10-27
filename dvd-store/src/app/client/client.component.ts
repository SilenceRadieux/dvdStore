import { Component, OnInit } from '@angular/core';
import { ClientServiceService } from '../services/client-service.service';
import { Client } from '../interface/client';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

  clients: Client[] = [];

  constructor( private clientApi: ClientServiceService) {}

  ngOnInit() {
    this.clientApi.getAllClients()
      .then(res => {
        this.clients = res
      })
      .catch((error) => {
        console.error(error.message)
      });
  }

}
