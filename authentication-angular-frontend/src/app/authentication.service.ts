import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  //url: string = "localhost:8086/authentication-service/users/login"
  url: string = "http://localhost:8081/users/login";


  httpOptions = { headers: new HttpHeaders({ 'Content-Type':  'application/json', }), responseType: 'text' as 'json' };

  constructor(private httpClient: HttpClient){}

  authenticateUser(username: string, password: string): Observable<any>{
    return this.httpClient.get(`${this.url}/${username}/${password}`, { responseType: 'text'});
  }
}