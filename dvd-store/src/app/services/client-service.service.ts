import { Injectable } from '@angular/core';
import {Client} from "../interface/client";
import axios from "axios";

@Injectable({
  providedIn: 'root'
})
export class ClientServiceService {

  constructor() {}
  private apiUrl = 'http://localhost:90/client';

  getClientById = async (clientId: string) => {
    try {
      const response = await axios.get(`${this.apiUrl}/${clientId}`);

      if (response.data) {
        const data = response.data;
        const client = {
          id: data.id,
          name: data.name,
          email: data.email,
        };

        return client;
      } else {
        throw new Error('Le serveur n\'a pas renvoyé de données pour le client avec l\'ID spécifié.');
      }
    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la récupération du client : ' + error);
    }
  }

  getAllClients = async () => {
    try {
      const response = await axios.get(this.apiUrl);
      if (Array.isArray(response.data)) {
        const clients: Client[] = response.data.map((data: any) => ({
          id: data.id,
          name: data.name,
          email: data.email,
        }));

        return clients;
      } else {
        throw new Error('Le serveur n\'a pas renvoyé de données pour les clients.');
      }
  } catch (error) {
    throw new Error('Une erreur s\'est produite lors de la récupération des clients : ' + error);
  }
}
}
