import { Injectable } from '@angular/core';
import { IMessage } from '@stomp/stompjs';
import { Message } from '../models/message';
import { ChatPageComponent } from '../chat-page/chat-page.component';
import { NotificationService } from './notification.service';

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  private username: string;
  private chatPage: ChatPageComponent;

  constructor(private notificationService: NotificationService) { }

  addMessage(message: Message) {
    this.chatPage.addMessage(message);
  }

  isMyMessage(message: any): boolean {
    return message.sender === this.username;
  }

  getUsername(): string {
    return this.username;
  }

  setUsername(username: string): void {
    this.username = username;
  }

  setChat(instance: ChatPageComponent): void {
    this.chatPage = instance;
  }

  async onMessageReceived(payload: IMessage) {
    const message = JSON.parse(payload.body) as Message;
    switch(message.type) {
      case 'JOIN':
        message.content = `${message.sender} dołączył do czatu!`;
        await this.notificationService.displayToast('success', message.content, 2000);
        break;
      case 'LEAVE':
        message.content = `${message.sender} opuścił czat!`;
        await this.notificationService.displayToast('warning', message.content, 2000);
        break;
    }
    this.addMessage(message);
    this.chatPage.scrollToBottom();
  }
}
