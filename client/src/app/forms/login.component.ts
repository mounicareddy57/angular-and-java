import { Component } from '@angular/core';


@Component({
    moduleId: module.id,
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user = {};

  loginUser(){
    console.log(this.user);
  }

}

