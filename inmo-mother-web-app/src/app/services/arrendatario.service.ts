import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Arrendatario } from '../models/arrendatario';
import { EndPoint } from '../utils/end-point';
import { map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ArrendatarioService {

  private endPoint: EndPoint = new EndPoint();

  constructor(private _http: HttpClient) { }

  public listarArrendatarios(): Observable<Arrendatario[]> {
    return this._http.get<Arrendatario[]>(this.endPoint.arrendatario)
    .pipe( map(response => response[this.endPoint.embedded]) );;
  }

}
