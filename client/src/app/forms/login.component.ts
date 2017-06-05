import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../user/user-authentication.service";
import {UserService} from "../user/user.service";


@Component({
    moduleId: module.id,
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  user = {email: '', password: ''};
  errorMessage: string= null;
  constructor(private userService: UserService, private authenticationService: AuthenticationService, private router: Router){

  }

  ngOnInit() {
    this.authenticationService.logout();
  }

  loginUser(){
    console.log(this.user);
    this.authenticationService.login(this.user)
      .subscribe(
        result => {
          if (result === true)
            this.router.navigate(['home/movies']);
        },
        error => {
          this.errorMessage = 'Username or password is incorrect';
          console.log(error);
        });
  }

}



