import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders, HttpRequest} from "@angular/common/http";
import {Message} from "./model/message";
import {Observable} from "rxjs/index";
import {Authent} from "./model/authent";
import {Person} from "./model/person";

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json',
    'Authorization': 'my-auth-token'})
};

@Injectable({
  providedIn: 'root'
})

export class MessageService {

  constructor(private http: HttpClient) { }

  private getMsgsUrl: string = 'http://localhost:8080';
  private deleteMsgUrl: string = 'http://localhost:8080/delete/';
  private postMsgUrl: string = 'http://localhost:8080/send';
  private authentUrl: string= 'http://localhost:8080/check';
  private getPersUrl: string= 'http://localhost:8080/find/';

  public getMessages(email: string): Observable<Message[]>{
    console.log("email : "+email);
    return this.http.post<Message[]>(this.getMsgsUrl, email);
  }

  public getMessage(id: number): Observable<Message>{
    return this.http.get<Message>(this.getMsgsUrl+'/message/'+id);
  }

  public deleteMessage(id: number){
    console.log(this.deleteMsgUrl+id);
    return this.http.delete(this.deleteMsgUrl+id);
  }

  public sendMessage(message: Message): Observable<Message>{
    console.log("msg : "+message.subject);
    return this.http.post<Message>(this.postMsgUrl, message);
  }

  public checkPassword(authent: Authent){
    return this.http.post(this.authentUrl, authent,httpOptions);
  }

  public getPersonByEmail(email: string): Observable<Person>{
    return this.http.get<Person>(this.getPersUrl+email);
  }
}
