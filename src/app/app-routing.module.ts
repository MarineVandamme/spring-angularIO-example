 import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
 import {MessagesComponent} from "./messages/messages.component";
 import {MessageComponent} from "./message/message.component";
 import {EmailComponent} from "./email/email.component";

const routes: Routes = [
  {path: 'messages', component: MessagesComponent},
  {path: 'message/:idMessage', component:MessageComponent},
  {path: 'send', component: EmailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
