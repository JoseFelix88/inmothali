import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { Notificacion } from 'src/app/utils/notificacion';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  nombreUsuarioLogin: string = "Jose Felix Curiel";
  
  constructor(private _authService: AuthService) {
      this.nombreUsuarioLogin = _authService.usuario.nombreUsuario;
   }

  ngOnInit() {
  }
  
  cerrarSession(): void {
    Notificacion.showNotifyTypeSuccess(this.nombreUsuarioLogin + ' haz cerrado sesión correctamente.');
    this._authService.cerrarSession();
  }
}
