import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import { HomeComponent } from './home/home.component';
import { DetailsDvdComponent } from './details-dvd/details-dvd.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path :'login',
    component: LoginComponent
  },
  {
    path: 'details-dvd/:id',
    component: DetailsDvdComponent,
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
