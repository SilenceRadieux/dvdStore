import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { DvdComponent } from './dvd/dvd.component';
import { DetailsDvdComponent } from './details-dvd/details-dvd.component';
import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { RouteReuseStrategy } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EditDvdComponent } from './edit-dvd/edit-dvd.component';
import { MatDialogModule } from '@angular/material/dialog';
import { DashboardSideBarComponent } from './dashboard-side-bar/dashboard-side-bar.component';
import { ClientComponent } from './client/client.component';
import { SaleComponent } from './sale/sale.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavBarComponent,
    SideBarComponent,
    DvdComponent,
    DetailsDvdComponent,
    DashboardComponent,
    EditDvdComponent,
    DashboardSideBarComponent,
    ClientComponent,
    SaleComponent
  ],
  imports: [

    BrowserModule,
    AppRoutingModule,
    FormsModule,
    IonicModule.forRoot(),
    BrowserAnimationsModule,
    MatDialogModule,

  ],
  providers: [
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
