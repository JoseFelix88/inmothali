import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  public formGroupLogin: FormGroup;

  constructor(private _formBuildLogin: FormBuilder) { }
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
    console.log(this.formGroupLogin.value);
  }

}
