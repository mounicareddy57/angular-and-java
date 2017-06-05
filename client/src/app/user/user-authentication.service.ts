import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
  public token: string;

  constructor(private http: Http) {

    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.token = currentUser && currentUser.token;
  }

  login(user: any): Observable<boolean> {
    return this.http.post('http://localhost:8080/api-module/api/user/login', user)
      .map((response: Response) => {

        let token = response.json() && response.json().token;
        if (token) {

          this.token = token;
          user.role = response.json().role;

          localStorage.setItem('currentUser', JSON.stringify(user));
          return true;
                  }
        else {

          return false;
        }
      });
  }

  logout(): void {

    this.token = null;
    localStorage.removeItem('currentUser');
  }
}
