import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Usuario } from '../models/usuario';
import { EndPoint } from '../utils/end-point';
import { HttpHeaderEnum } from '../utils/enums/http-header-enum';

@Injectable({
  providedIn: 'root'
})
export class AuthService extends EndPoint {

  constructor(private _http: HttpClient) {
    super();
  }

  login(usuariologin: Usuario): Observable<any> {
    console.log(HttpHeaderEnum);
    const credentials = btoa(HttpHeaderEnum.CLIENT_ID + HttpHeaderEnum.TOKEN_CREDENTIALS + HttpHeaderEnum.SECRECT_ID);
    const httpHeaders = new HttpHeaders({
      'Content-Type' : HttpHeaderEnum.CONTENT_TYPE,
      'Authorization' : HttpHeaderEnum.AUTHORIZATION + credentials
    });
    let params = new URLSearchParams();
    params.set(HttpHeaderEnum.GRANT_TYPE, HttpHeaderEnum.GRANT_TYPE_PASSWORD);
    params.set('username', usuariologin.userName);
    params.set('password', usuariologin.password);
    console.log("params:"+ params.toString());
    console.log("httpHeaders: " + httpHeaders.get('Authorization'));
    console.log("urlToken: "+ this.token);
    return this._http.post<any>(this.token, params.toString(), { headers : httpHeaders });
  }

}
