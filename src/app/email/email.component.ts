import { Component, OnInit } from '@angular/core';
import {Message} from "../model/message";
import {MessageService} from "../message.service";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {FormBuilder, FormControl, FormGroup, Validator, Validators} from "@angular/forms";
import {AppComponent} from "../app.component";

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {

  message: Message = new Message();
  email: string;

  constructor(private route: ActivatedRoute,
              private http: HttpClient,
              private router: Router,
              private messageService: MessageService,
              private formBuilder: FormBuilder,
              private appComponent: AppComponent) {}

  sendForm: FormGroup;

  ngOnInit() {
    this.sendForm = new FormGroup({
      email: new FormControl(this.message.topers, [Validators.required,Validators.pattern("[^ @]*@[^ @]*")]),
      subject: new FormControl(this.message.subject, [Validators.required]),
      text: new FormControl(this.message.text,[Validators.required])
    });
    this.message.frompers=this.appComponent.authent.email;
  }

  onSubmit(){
    console.log(this.message);
    this.messageService.sendMessage(this.message)
      .subscribe(
        msg => this.router.navigateByUrl("/messages"),
        error => alert("cannot post email")
      )
  }

}
