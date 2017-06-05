import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MoviesService} from "./movies.service";

@Component({
  templateUrl: './movies-edit.component.html'
})
export class MoviesEditComponent {

  moviesList: any = {};

  constructor(private route: ActivatedRoute, private router: Router, private moviesService: MoviesService) {

    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    console.log(currentUser);
    if(currentUser && currentUser.role!='admin'){
      this.router.navigate(['home/movies']);
    }

    this.route.params.subscribe(
      params => {
        moviesService.getMoviesById(params['id'])
          .subscribe(
            movie => this.moviesList = movie,
            error => console.log(error)
          );
      });
  }

  updateMovie(): void{
    this.moviesService.updateMovies(this.moviesList.mid, this.moviesList)
      .subscribe(
        response => this.router.navigate(['home/movies',this.moviesList.mid]),
        error => console.log(error)
      );
  }
}
