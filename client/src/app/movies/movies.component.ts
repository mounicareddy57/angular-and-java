import {Component, OnInit} from '@angular/core';
import {MoviesService} from "./movies.service";
import {AuthenticationService} from "../user/user-authentication.service";
import {Router} from "@angular/router";
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
  Admin:boolean = false;

  constructor(private moviesService: MoviesService, private router: Router, private authenticationService: AuthenticationService){
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if(currentUser && currentUser.role=='admin'){
      this.Admin = true;
    }
  }
 ngOnInit():void
 {
    this.moviesService.getMovies()
        .subscribe(
            movies => this.moviesList = movies,
            error => console.log(error));
  }

  LogOut(): void {
    this.authenticationService.logout();
    this.router.navigate(['home/login']);
  }

}






