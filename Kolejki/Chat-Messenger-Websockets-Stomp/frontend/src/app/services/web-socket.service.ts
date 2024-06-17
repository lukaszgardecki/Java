import { Injectable } from '@angular/core';
import { Client} from '@stomp/stompjs';
import { Message } from '../models/message';
import { BehaviorSubject } from 'rxjs';
import { ChatService } from './chat.service';
import { NotificationService } from './notification.service';

@Injectable({
  providedIn: 'root',
})
export class WebSocketService {
  private serverUrl = "http://localhost:8080/websocket";
  private stompClient: Client;
  private isConnectedSubject = new BehaviorSubject<boolean>(false);
  isConnected$ = this.isConnectedSubject.asObservable();

  constructor(
    private chatService: ChatService,
    private notificationService: NotificationService
  ) { }

  public connect() {
    this.stompClient = this.createClient();
    this.stompClient.activate();
    this.isConnectedSubject.next(true);
  }

  public disconnect() {
    this.leaveTheChat();
    this.stompClient.deactivate();
    this.isConnectedSubject.next(false);
  }

  public send(message: Message) {
    this.stompClient.publish({
      destination: "/app/chat.send",
      body: JSON.stringify(message)
    });
  }

  private createClient() {
    return new Client({
      brokerURL: this.serverUrl,
      debug: function (str) {
        console.log(str);
      },
      reconnectDelay: 200,
      heartbeatIncoming: 0,
      heartbeatOutgoing: 20000,
      onConnect: () => this.joinTheChat(),
      onStompError: async () => this.notificationService.displayErrorToast()
    });
  }

  private joinTheChat() {
    const username = this.chatService.getUsername();
    this.stompClient.subscribe("/topic/public", (message) => this.chatService.onMessageReceived(message));
    this.stompClient.publish({
      destination: "/app/chat.register", 
      body: JSON.stringify({sender: username, type: 'JOIN'})
    });
  }

  private leaveTheChat() {
    const username = this.chatService.getUsername();
    this.stompClient.publish({
      destination: "/app/chat.register", 
      body: JSON.stringify({sender: username, type: 'LEAVE'})
    });
  }
}
