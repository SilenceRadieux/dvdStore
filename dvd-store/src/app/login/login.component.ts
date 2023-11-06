import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

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
        this.authService.login(this.username, this.password).subscribe(
          (response) => {
            this.router.navigate(['/home']);
          },
          (error) => {
            this.errorMessage = 'Authentication failed. Please check your credentials.';
          }
        );
  }

}
