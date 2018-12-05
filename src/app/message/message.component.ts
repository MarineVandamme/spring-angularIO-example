import { Component, OnInit } from '@angular/core';
import {Message} from "../model/message";
import {HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {MessageService} from "../message.service";
import {Person} from "../model/person";
import {invalidPipeArgumentError} from "@angular/common/src/pipes/invalid_pipe_argument_error";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  constructor(private router: Router, private messageService: MessageService) { }

  message: Message = null;
  idMessage: number;
  person: Person = null;

  ngOnInit() {
    var url = this.router.url;
    var a = url.split('/'[0]);
    this.idMessage = parseInt(a[2]);
    console.log(this.idMessage);
    this.messageService.getMessage(this.idMessage)
      .subscribe(res=>{
        this.message = res;
        this.findPerson(res.frompers);
      },
          error => alert("cannot get message")
      )
  }

  findPerson(email: string){
    this.messageService.getPersonByEmail(email)
      .subscribe(res2=>{
        this.person=res2;
      },
      error=>alert("cannot get person")
  )
  }
}
