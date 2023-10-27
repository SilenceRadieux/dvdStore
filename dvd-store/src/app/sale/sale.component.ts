import { Component, OnInit } from '@angular/core';
import { SaleServiceService } from '../services/sale-service.service';
import { Sale } from '../interface/sale';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.scss']
})
export class SaleComponent implements OnInit {

sales: Sale[] = [];

constructor( private saleApi: SaleServiceService) {}

ngOnInit() {
  this.saleApi.getAllSales()
    .then(res => {
      this.sales = res
    })
    .catch((error) => {
      console.error(error.message)
    });
  }

}
