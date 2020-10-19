import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { AuthService } from 'src/app/services/auth.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  public formGroupLogin: FormGroup;
  usuarioLogin: Usuario;

  constructor(private _formBuildLogin: FormBuilder,
    private _authService: AuthService, 
    private _router:Router) { }


  ngOnInit(): void {
    this.buildFormLogin();
    if(this._authService.isAuthenticated()) {
      Swal.fire('LOGIN', 'Hola ' + this._authService.usuario.nombreUsuario + ' ya estás autenticado!', 'info');
      this._router.navigate(['/menu']);
    }
  }

  private buildFormLogin() {
    this.formGroupLogin = this._formBuildLogin.group({
      username: ['', [ 
        Validators.required, Validators.minLength(6)]],
      password: ['', [
        Validators.required, Validators.minLength(4)]]
    });
  }

  /**
   * login
   */
  public login() {
    const userValueLogin = this.formGroupLogin.value;
    this.usuarioLogin = new Usuario(userValueLogin.username, userValueLogin.password);
    this._authService.login(this.usuarioLogin).subscribe(auth => {
      this._authService.guardarToken(auth.access_token);
      this._authService.guardarUsuario(auth.access_token);
      let usuario = this._authService.usuario;
      Swal.fire('LOGIN', 'Hola ' + usuario.nombreUsuario + ' haz iniciado session.', 'info');
      this._router.navigate(['/menu']);
    });
  }


  public getError(controlName: string): string {
    let error = '';
    const control = this.formGroupLogin.get(controlName);
    if (control.touched && control.errors != null) {
      error = JSON.stringify(control.errors);
    }
    return error;
  }

}
