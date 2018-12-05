import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Authent} from "./model/authent";
import {MessageService} from "./message.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'soa-app';
  authent: Authent=new Authent;
  authForm: FormGroup;
  isAuthent:Boolean=false;
  email: string;

  constructor(private router: Router, private messageService: MessageService){}

  ngOnInit(){
    this.authForm = new FormGroup({
      user: new FormControl(this.authent.email, [Validators.required,Validators.pattern("[^ @]*@[^ @]*")]),
      password: new FormControl(this.authent.password, [Validators.required])
    });
  }

  checkPassword(){
    this.messageService.checkPassword(this.authent)
      .subscribe(
        res=>{
          if(res){
            this.isAuthent=true;
            //ocalStorage.setItem("isAuthent","true");
            this.email=this.authent.email;
            //localStorage.setItem("email", this.email);
            this.router.navigateByUrl('/messages')
          }
          else {
            alert("One of userId or Password is wrong");
          }
        },
        error=>alert("Cannot check password")
      )
  }

}
