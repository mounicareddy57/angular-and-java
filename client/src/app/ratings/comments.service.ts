import { Injectable } from '@angular/core';
import {Http, RequestOptions, Headers} from "@angular/http";
import {AuthenticationService} from "../user/user-authentication.service";
import {Observable} from "rxjs";

@Injectable()
export class CommentsService {

  constructor(private http:Http,  private authenticationService: AuthenticationService) {}

    getCommentsByMovie(moviesId: String): Observable<any[]> {
      return this.http.get(`http://localhost:8080/api-module/api/comments/movie/${moviesId}`)
        .map(response => response.json())
        .catch(error => Observable.throw(error.statusText));
  }

  createComments(com: String): Observable<any[]>{
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post(`http://localhost:8080/api-module/api/comments`,com, options)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }


}
