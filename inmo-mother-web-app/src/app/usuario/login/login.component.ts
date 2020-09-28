import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Usuario } from 'src/app/models/usuario';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  public formGroupLogin: FormGroup;
  usuarioLogin: Usuario;

  constructor(private _formBuildLogin: FormBuilder,
    private _authService: AuthService) { }
  ngOnInit(): void {
    this.buildFormLogin();
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
      console.log("Token-auth: " + auth);
    });
  }

}
