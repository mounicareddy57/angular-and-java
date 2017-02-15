
import {Component} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {MoviesService} from "./movies.service";

@Component({
    moduleId: module.id,
    templateUrl: './movies-detail.component.html',
    styleUrls: ['./movies-detail.component.css']
})
export class MoviesDetailComponent
{
    moviesList: any = {};
    constructor(private route: ActivatedRoute, private moviesService: MoviesService) {
        this.route.params.subscribe(
            params => {
                moviesService.getMoviesById(params['id'])
                    .subscribe(
                        movies => this.moviesList = movies,
                        error => console.log(error)
                    );
            });
    }
}
