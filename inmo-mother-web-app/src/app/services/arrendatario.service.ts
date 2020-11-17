import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
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
  private _arrendatario: Arrendatario;
  
  constructor(private _http: HttpClient) { }

  public listarArrendatarios(): Observable<Arrendatario[]> {
    return this._http.get<Arrendatario[]>(this.endPoint.arrendatario)
    .pipe( map(response => response[this.endPoint.embedded]) );;
  }
  
  public listarArrendatariosPaginados(page: string, size: string): Observable<any> {
    const params = new HttpParams()
    .set('page', page)
    .set('size', size);
    return this._http.get<Arrendatario[]>(this.endPoint.arrendatario, {params: params});
  }
  
  public obtenerArrendatario(codigoArrendatario: number): Observable<any> {
    const params = new HttpParams()
    .set('codigoArrendatario', codigoArrendatario.toString());
    return this._http.get(this.endPoint.arrendatario, {params: params});
  }

  public get arrendatario(): Arrendatario {
    return this._arrendatario;
  }

  public set arrendatario(value: Arrendatario) {
    this._arrendatario = value;
  }
}
