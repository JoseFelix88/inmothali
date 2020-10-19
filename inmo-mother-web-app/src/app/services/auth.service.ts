import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Usuario } from '../models/usuario';
import { EndPoint } from '../utils/end-point';
import { HttpHeaderEnum } from '../utils/enums/http-header-enum';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public endPoint: EndPoint = new EndPoint();

  private _usuario: Usuario;
  private _token: string;
  
  constructor(private _http: HttpClient) {
  }

  login(usuariologin: Usuario): Observable<any> {
    const credentials = btoa(HttpHeaderEnum.CLIENT_ID + HttpHeaderEnum.TOKEN_CREDENTIALS + HttpHeaderEnum.SECRECT_ID);
    const httpHeaders = new HttpHeaders({
      'Content-Type' : HttpHeaderEnum.CONTENT_TYPE,
      'Authorization' : HttpHeaderEnum.AUTHORIZATION + credentials
    });

    let params = new URLSearchParams();
    params.set(HttpHeaderEnum.GRANT_TYPE, HttpHeaderEnum.GRANT_TYPE_PASSWORD);
    params.set('username', usuariologin.userName);
    params.set('password', usuariologin.password);
    
    return this._http.post<any>(this.endPoint.urlOauthToken, params.toString(), { headers : httpHeaders });
  }

  guardarUsuario(accesToken: string): void {
    let payload = this.obtenerDatosToken(accesToken);
    this._usuario = new Usuario(null, null);
    this._usuario.nombreUsuario = payload.nombre_usuario;
    this._usuario.userName = payload.user_name;
    this._usuario.codigoUsuario = payload.codigo_usuario;
    this._usuario.roles = payload.authorities;
    sessionStorage.setItem('usuario', JSON.stringify(this._usuario));
  }

  guardarToken(accesToken: string): void {
    this._token = accesToken;
    sessionStorage.setItem('token', this._token);
  }

  obtenerDatosToken(accesToken: string): any {
    if(accesToken != null) {
      return JSON.parse(atob(accesToken.split(".")[1]));
    }
    return null;
  }

  public get usuario(): Usuario {
    if(this._usuario != null){
      return this._usuario;
    } else if(this._usuario == null && sessionStorage.getItem('usuario') != null) {
      this._usuario = new Usuario(null, null);
      this._usuario.nombreUsuario = JSON.parse(sessionStorage.getItem('usuario'))._nombre_usuario;
      return this._usuario;
    }
    return new Usuario(null, null);
  }
  
  public get token(): string {
    if(this._token != null){
      return this._token;
    } else if(this._token == null && sessionStorage.getItem('token') != null) {
      this._token = sessionStorage.getItem('token');
      return this._token;
    }
    return this._token;
  }
  
  isAuthenticated(): boolean {
    let payload = this.obtenerDatosToken(this.token);
    if(payload != null && payload.user_name && payload.user_name.length > 0) {
      return true;
    }
    return false;
  }


}
