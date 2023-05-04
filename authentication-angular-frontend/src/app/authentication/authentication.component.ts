import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { AuthenticationService } from '../authentication.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit{
  username! : string;
  password! : string;
  message! : string;

  user: User = new User();

  constructor(private service: AuthenticationService, private route: ActivatedRoute){}

  ngOnInit(): void {
    this.username = this.route.snapshot.params['username'];
    this.password = this.route.snapshot.params['password'];
  }

  authenticateUser(username:string, password:string){
    this.service.authenticateUser(this.username, this.password).subscribe(data => {
      this.message = data;
    });
  }

}

