import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {DataTableModule,SharedModule} from 'primeng/primeng';
import {RatingModule} from 'primeng/primeng';


import { AppComponent } from './app.component';
import { MoviesComponent } from './movies/movies.component';
import { UserComponent } from './user/user.component';
import {MoviesService} from "./movies/movies.service";
import {NotFoundComponent} from "./NotFoundComponent";
import {SignupComponent} from "./forms/signup.component";
import {LoginComponent} from "./forms/login.component";
import {HomeComponent} from "./home.component";
import {AppRoutingModule} from "./app-routing.module";
import {MoviesDetailComponent} from "./movies/movies-detail.component";
import {FilterPipe} from "./app.pipe";
import {UserService} from "./user/user.service";
import {AuthenticationService} from "./user/user-authentication.service";
import {MoviesEditComponent} from "./movies/movies-edit.component";
import {MoviesCreateComponent} from "./movies/movies-create.component";
import {CommentsService} from "./ratings/comments.service";



@NgModule({
  declarations: [AppComponent, MoviesComponent, UserComponent,
                SignupComponent,LoginComponent,MoviesCreateComponent,NotFoundComponent,MoviesEditComponent,HomeComponent, MoviesDetailComponent,FilterPipe,
                ],
  imports: [BrowserModule, FormsModule, HttpModule,AppRoutingModule, DataTableModule, RatingModule, SharedModule],
  providers: [MoviesService, UserService, AuthenticationService, CommentsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
