import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from "@angular/http";
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

@Injectable()
export class MoviesService {

  constructor(private http: Http)
  {}
    getMovies(): Observable<any[]> {
     return this.http.get('http://localhost:8080/api-module/api/movies')
                     .map(response => response.json())
                     .catch(error => Observable.throw(error.statusText));
  }
    getMoviesById(id: String): Observable<any[]> {
        return this.http.get(`http://localhost:8080/api-module/api/movies/${id}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    getMoviesByTitle(title: String): Observable<any[]>{
      return this.http.get(`http://localhost:8080/api-module/api/movies/title/${title}`)
        .map(response => response.json())
        .catch(error => Observable.throw(error.statusText));

    }

    getMoviesByType(type: String): Observable<any[]>{
      return this.http.get(`http://localhost:8080/api-module/api/movies/type/${type}`)
        .map(response => response.json())
        .catch(error => Observable.throw(error.statusText));

    }
  getMoviesByYear(year: String): Observable<any[]>{
    return this.http.get(`http://localhost:8080/api-module/api/movies/year/${year}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));

  }

  getMoviesByGenre(genre: String): Observable<any[]>{
    return this.http.get(`http://localhost:8080/api-module/api/movies/genre/${genre}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));

  }
    createMovies(mov: any): Observable<any[]> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.get('http://localhost:8080/api-module/api/movies',mov)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    updateMovies(id: String, mov:any): Observable<any[]> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.get(`http://localhost:8080/api-module/api/movies/${id}`,mov)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
}
