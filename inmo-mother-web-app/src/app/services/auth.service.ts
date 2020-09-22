import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { URLSearchParams } from 'url';
import { EndPoint } from '../utils/end-point';

@Injectable({
  providedIn: 'root'
})
export class AuthService extends EndPoint {

  constructor(private _httpClient: HttpClient) {
    super();
  }

  login(): Observable<any> {
    const credentials = btoa("inmoeleonor" + ":" + "thali_1805");
    const httpHeaders = new HttpHeaders({
      'Content-Type' : 'application/x-www-form-urlencoded',
      'Authorization' : 'Basic ' + credentials
    });
    let params = new URLSearchParams();
    params.set('grant_type', 'password');
    params.set('username', 'josefelix');
    params.set('password', '456312');
    return this._httpClient.post<any>(this.token, params, { headers : httpHeaders });
  }

}
