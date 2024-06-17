import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Message } from '../models/message';
import { WebSocketService } from '../services/web-socket.service';
import { ChatService } from '../services/chat.service';

@Component({
  selector: 'app-chat-page',
  templateUrl: './chat-page.component.html',
  styleUrl: './chat-page.component.css'
})
export class ChatPageComponent implements OnInit {
  @ViewChild('messageContainer') private messageContainer: ElementRef;
  messages: Array<Message> = [];
  messageContent: string;
  isConnected: boolean = false;

  constructor(
    private webSocketService: WebSocketService,
    private chatService: ChatService
  ) {
    webSocketService.isConnected$.subscribe({
      next: isConnected => this.isConnected = isConnected
    });
  }

  ngOnInit(): void {
    this.chatService.setChat(this);
  }

  send() {
    if (this.messageContent && this.isConnected) {
      const username = this.chatService.getUsername();
      const message = Message.createChatMsg(this.messageContent, username);
      this.webSocketService.send(message);
    }
    this.messageContent = "";
  }

  
  public addMessage(message: Message) {
    this.messages.push(message);
  }

  disconnect() {
    this.webSocketService.disconnect();
  }

  isMyMessage(message: Message): boolean {
    return this.chatService.isMyMessage(message);
  }

  public scrollToBottom() {
    try {
      requestAnimationFrame(() => {
        const container = this.messageContainer.nativeElement;
        container.scrollTop = container.scrollHeight;
      });
    } catch (err) {
      console.error('Could not scroll to bottom:', err);
    }
  }

  getAvatarColor(username: string) {
    let hash = 0;
    const colors = [
        '#2196F3', '#32c787', '#00BCD4', '#ff5652',
        '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
    ];

    for (let i = 0; i < username.length; i++) {
        hash = 31 * hash + username.charCodeAt(i);
    }

    let index = Math.abs(hash % colors.length);
    return colors[index];
  }
}
