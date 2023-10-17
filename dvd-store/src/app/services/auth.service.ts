import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:90/login';

  constructor() { }

  login(username: string, password: string) {
      const loginData = {
        username: username,
        password: password,
      };

      return axios.post(`${this.apiUrl}/authorize`, loginData);
    }

    register(username: string, password: string) {
      const registrationData = {
        username: username,
        password: password,
      };

      return axios.post(`${this.apiUrl}/register`, registrationData);
    }

}
