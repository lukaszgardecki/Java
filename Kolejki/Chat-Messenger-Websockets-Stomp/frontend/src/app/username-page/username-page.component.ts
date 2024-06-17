import { Component } from '@angular/core';
import { WebSocketService } from '../services/web-socket.service';
import { ChatService } from '../services/chat.service';

@Component({
  selector: 'app-username-page',
  templateUrl: './username-page.component.html',
  styleUrl: './username-page.component.css'
})
export class UsernamePageComponent {
  username: string = "";
  
  constructor(
    private webSocketService: WebSocketService,
    private chatService: ChatService
  ) { }

  connect() {
    const username = this.username.trim();
    if (username) {
      this.webSocketService.connect();
      this.chatService.setUsername(username);
    }
  }
}
