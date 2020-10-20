import { Component, OnInit } from '@angular/core';
//import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  nombreUsuarioLogin: string = "Jose Felix Curiel";
  
  constructor() {
    //this.nombreUsuarioLogin = _authService.usuario.nombreUsuario;
   }

  ngOnInit() {
  }

}
