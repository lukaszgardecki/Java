import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { WebSocketService } from './services/web-socket.service';
import { FormsModule } from '@angular/forms';
import { ChatPageComponent } from './chat-page/chat-page.component';
import { UsernamePageComponent } from './username-page/username-page.component';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
    UsernamePageComponent,
    ChatPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    WebSocketService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
