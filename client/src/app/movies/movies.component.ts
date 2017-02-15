import {Component, OnInit} from '@angular/core';
import {MoviesService} from "./movies.service";
/*import {subscribeOn} from "rxjs/operator/subscribeOn";*/

@Component({
  moduleId: module.id,
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit
{
  title:string;
  moviesList: any =[];

  constructor(private moviesService: MoviesService){}
 ngOnInit():void
 {
    this.moviesService.getMovies()
        .subscribe(
            movies => this.moviesList = movies,
            error => console.log(error));
  }
imdbview(){

}

}






