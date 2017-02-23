import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MoviesService} from "app/movies/movies.service";

@Component({
  moduleId: module.id,
  templateUrl: './movies-create.component.html'
})
export class MoviesCreateComponent {

  moviesList: any = {};

  constructor(private router: Router, private moviesService: MoviesService) {
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if(currentUser && currentUser.role!='admin'){
      this.router.navigate(['home/movies']);
    }
  }

  createMovies(): void{
    this.moviesService.createMovies(this.moviesList)
      .subscribe(
        movie => {
          this.moviesList = movie;
          this.router.navigate(['home/movies',this.moviesList.id])
        },
        error => console.log(error)
      );
  }
}
