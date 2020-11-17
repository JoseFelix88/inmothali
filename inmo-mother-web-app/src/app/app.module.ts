import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MaterialModule } from './material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { routing } from './app.routing';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './usuario/login/login.component';
import { AuthService } from './services/auth.service';
import { MenuComponent } from './share/menu/menu.component';
import { NavbarComponent } from './share/navbar/navbar.component';
import { ListArrendatarioComponent } from './components/arrendatario/list-arrendatario/list-arrendatario.component';
import { LoadingComponent } from './share/loading/loading.component';
import { AddEditArrendatarioComponent } from './components/arrendatario/add-edit-arrendatario/add-edit-arrendatario.component';
import { MatDialogRef } from '@angular/material/dialog';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    NavbarComponent,
    ListArrendatarioComponent,
    LoadingComponent,
    AddEditArrendatarioComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    SweetAlert2Module,
    routing
  ],
  providers: [AuthService, {
    provide: MatDialogRef,
    useValue: {}
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
