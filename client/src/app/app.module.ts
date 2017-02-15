import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';


import { AppComponent } from './app.component';
import { MoviesComponent } from './movies/movies.component';
import { UserComponent } from './user/user.component';
import { RatingsComponent } from './ratings/ratings.component';
import { CommentsComponent } from './comments/comments.component';
import {MoviesService} from "./movies/movies.service";
import {NotFoundComponent} from "./NotFoundComponent";
import {SignupComponent} from "./forms/signup.component";
import {LoginComponent} from "./forms/login.component";
import {LoginModule} from "./forms/login.module";
import {HomeComponent} from "./home.component";
import {AppRoutingModule} from "./app-routing.module";
import {MoviesDetailComponent} from "./movies/movies-detail.component";
import {FilterPipe} from "./app.pipe";



@NgModule({
  declarations: [AppComponent, MoviesComponent, UserComponent, RatingsComponent, CommentsComponent,
                SignupComponent,LoginComponent,NotFoundComponent,HomeComponent, MoviesDetailComponent,FilterPipe,
                ],
  imports: [BrowserModule, FormsModule, LoginModule, HttpModule,AppRoutingModule],
  providers: [MoviesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
