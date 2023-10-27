import { Injectable } from '@angular/core';
import {Dvd} from "../interface/dvd";
import axios from "axios";

@Injectable({
  providedIn: 'root'
})
export class DvdServiceService {

  constructor() {}
  private apiUrl = 'http://localhost:90/dvd';

  getDvdById = async (dvdId: string) => {
    try {
      const response = await axios.get(`${this.apiUrl}/${dvdId}`);

      if (response.data) {
        const data = response.data;
        const dvd = {
          id: data.id,
          isan: data.isan,
          name: data.name,
          genre: data.genre,
          directedBy: data.directedBy,
          duration: data.duration,
          releaseDate: data.releaseDate,
          synopsis: data.synopsis,
          cover: data.cover,
          quantity: data.quantity,
          price: data.price,
        };

        return dvd;
      } else {
        throw new Error('Le serveur n\'a pas renvoyé de données pour le DVD avec l\'ID spécifié.');
      }
    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la récupération du DVD : ' + error);
    }
  }


  getAllDvds = async () => {
    try {
      const response = await axios.get(this.apiUrl);

      if (Array.isArray(response.data)) {
        const dvds: Dvd[] = response.data.map((data: any) => ({
          id: data.id,
          isan: data.isan,
          name: data.name,
          genre: data.genre,
          directedBy: data.directedBy,
          duration: data.duration,
          releaseDate: data.releaseDate,
          synopsis: data.synopsis,
          cover: data.cover,
          quantity: data.quantity,
          price: data.price,
        }));

        return dvds;
      } else {
        throw new Error('La réponse du serveur ne renvoie pas un tableau de DVDs.');
      }
    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la récupération des DVDs : ' + error);
    }
  }

  addCartDvd = async (dvd: Dvd) => {
    try {
      const response = await axios.post(this.apiUrl, dvd);
  } catch (error) {
    throw new Error('Une erreur s\'est produite lors de l\'ajout au panier : ' + error);
  }
  }

  updateDvd = async (dvd: Dvd) => {
    try {
      const response = await axios.put(this.apiUrl+"/"+dvd.id, dvd);
  } catch (error) {
    throw new Error('Une erreur s\'est produite lors de la modification du dvd : ' + error);
  }
  }

}
