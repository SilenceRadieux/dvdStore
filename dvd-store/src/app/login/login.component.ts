import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) { }

  login() {
    if (!this.username || !this.password) {
          this.errorMessage = 'Please enter both a username and password.';
          return;
        }
        this.authService.login(this.username, this.password).then(
          (response: any) => {
            this.router.navigate(['/home']);
          },
          (error: any) => {
            this.errorMessage = 'Authentication failed. Please check your credentials.';
          }
        );
  }

}
