import { Injectable } from '@angular/core';
import {Dvd} from "../interface/dvd";
import axios from "axios";

@Injectable({
  providedIn: 'root'
})
export class DvdServiceService {

  constructor() { }
  private apiUrl = 'http://localhost:90/dvd';

  getAllDvds = async () => {
    try {
      const response = await axios.get(this.apiUrl);

      if (Array.isArray(response.data)) {
        const dvds: Dvd[] = response.data.map((data: any) => ({
          isan: data.isan,
          name: data.name,
          genre: data.genre,
          directedBy: data.directedBy,
          duration: data.duration,
          releaseDate: data.releaseDate,
          synopsis: data.synopsis,
          cover: data.cover,
          quantity: data.quantity,
        }));

        return dvds;
      } else {
        throw new Error('La réponse du serveur ne renvoie pas un tableau de DVDs.');
      }
    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la récupération des DVDs : ' + error);
    }
  }
}
