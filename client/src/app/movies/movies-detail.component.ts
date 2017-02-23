
import {Component} from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {MoviesService} from "./movies.service";
import {CommentsService} from "../ratings/comments.service";

@Component({
    moduleId: module.id,
    templateUrl: './movies-detail.component.html',
    styleUrls: ['./movies-detail.component.css']
})
export class MoviesDetailComponent
{
    moviesList: any = {};
    comments: any={};
    isAdmin:boolean=false;
    constructor(private route: ActivatedRoute, private moviesService: MoviesService,private router: Router, private commentsService: CommentsService) {

      var currentUser = JSON.parse(localStorage.getItem('currentUser'));
      if(currentUser && currentUser.role=='admin'){
        this.isAdmin = true;
      }

        this.route.params.subscribe(
            params => {
                moviesService.getMoviesById(params['id'])
                    .subscribe(
                        movies => this.moviesList = movies,
                        error => console.log(error)
                    );
            });
      this.route.params.subscribe(
        params => {
          commentsService.getCommentsByMovie(params['moviesId'])
            .subscribe(
              comment => {
                this.comments = comment;
              },
              error => console.log(error)
            );
        });

    }
  deleteMovies(): void {
    this.moviesService.deleteMovies(this.moviesList.mid, this.moviesList)
      .subscribe(
        data => this.router.navigate(['']),
        error => console.log(error)
      );

  }
  addComment():void{
    if(this.comments.com.trim().length > 0) {
      this.comments.moviesList = this.moviesList;
      this.comments.user = JSON.parse(localStorage.getItem('currentUser'));
      this.commentsService.createComments(this.comments)
        .subscribe(
          response => this.router.navigate(['home/movies', this.moviesList.mid]),
          error => console.log(error)
        );
      location.reload();  //this.router.navigate(['movies', this.movie.id]); /*not working*/
    }

  }
}
