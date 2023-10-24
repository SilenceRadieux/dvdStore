import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:90';

  constructor() { }

  login(username: string, password: string): Promise<any> {
      const loginData = {
        username: username,
        password: password,
      };

      return axios.post(`${this.apiUrl}/authorize`, loginData)
      .then((response) => response.data)
      .catch((error) => Promise.reject(error));
    }

    register(username: string, password: string) {
      const registrationData = {
        username: username,
        password: password,
      };

      return axios.post(`${this.apiUrl}/register`, registrationData);
    }

}
