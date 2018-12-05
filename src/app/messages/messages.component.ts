import {Component, OnInit } from '@angular/core';
import {Message} from "../model/message";
import {MessageService} from "../message.service";
import {Router} from "@angular/router";
import {AppComponent} from "../app.component";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  messages: Message[];
  app: AppComponent;

  constructor(private router: Router, private messageService: MessageService, private appComponent: AppComponent) { }

  ngOnInit() {
    this.app=this.appComponent;
    this.messageService.getMessages(this.appComponent.authent.email)
      .subscribe(msgs => {
        this.messages = msgs;
      },
          error => alert("cannot get messages")
      )
  }

  deleteMessage(message: Message): void{
    this.messageService.deleteMessage(message.idMessage)
      .subscribe(data => {
          this.messages = this.messages.filter(m => m!== message);
        },
        error => alert("impossible de supprimer ce document")
  )
  }

}
