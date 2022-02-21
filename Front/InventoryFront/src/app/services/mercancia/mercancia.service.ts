import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MercanciaService {

  private API_SERVER = 'http://localhost:8080/mercancia/';
  constructor(

    private httpClient: HttpClient

  ) { }


  public save(mercancia: any): Observable<any> {
    return this.httpClient.post(this.API_SERVER,mercancia);
  }
}
