import { Component } from '@angular/core';
import {UserService} from "../user/user.service";
import {Router} from "@angular/router";

@Component({
    moduleId: module.id,
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent {
    user = {};

  constructor(private userService: UserService, private router: Router){}

  addUser(){
    this.userService.addUser(this.user).subscribe(error => console.log(error));
    this.router.navigateByUrl('home/movies');
  }
}
