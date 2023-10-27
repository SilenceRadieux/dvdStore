import { Injectable } from '@angular/core';
import { Sale } from "../interface/sale";
import axios from "axios";

@Injectable({
  providedIn: 'root'
})
export class SaleServiceService {

  constructor() { }
  private apiUrl = 'http://localhost:90/sale';

  getAllSales = async () => {
    try {
      const response = await axios.get(this.apiUrl);
      if (Array.isArray(response.data)) {
        const sales: any[] = response.data.map((data: any) => ({
          id: data.id,
          quantity: data.quantity,
          clientId: data.clientId,
          dvdId: data.dvdId,
        }));

        return sales;
  } else {
    throw new Error('Le serveur n\'a pas renvoyé de données pour les ventes.');
  }
} catch (error) {
  throw new Error('Une erreur s\'est produite lors de la création des ventes : ' + error);
}
  }

}
