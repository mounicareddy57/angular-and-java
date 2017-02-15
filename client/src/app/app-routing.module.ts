import { NgModule }              from '@angular/core';
import { RouterModule, Routes }  from '@angular/router';
import {HomeComponent} from "./home.component";
import {SignupComponent} from "./forms/signup.component";
import {MoviesComponent} from "./movies/movies.component";
import {LoginComponent} from "./forms/login.component";
import {NotFoundComponent} from "./NotFoundComponent";
import {MoviesDetailComponent} from "./movies/movies-detail.component";



const appRoutes: Routes = [
    { path: 'home', component:HomeComponent},
    { path: 'home/signup', component:SignupComponent},
    { path: 'home/login', component:LoginComponent},
    { path: 'home/movies', component:MoviesComponent},
    { path: 'home/login/signup', redirectTo:'/home/signup', pathMatch: 'full'},
    { path: 'home/login/movies', redirectTo:'/home/movies', pathMatch: 'full'},
    { path: 'home/movies/:id', component:MoviesDetailComponent},
    { path: '', redirectTo: '/home', pathMatch:'full'},
    { path: '**', component: NotFoundComponent}
];

@NgModule({
    imports: [
        RouterModule.forRoot(appRoutes, {useHash: true})
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {}
