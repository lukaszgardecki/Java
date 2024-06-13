import { Injectable } from '@angular/core';
import { RxStompService, StompService } from '@stomp/ng2-stompjs';
import { Stomp } from '@stomp/stompjs';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SocketProviderService {

  constructor(private rxStompService: RxStompService) {}

  public connect() {
    // return this.rxStompService.watch('/topic/notifications');
    return this.rxStompService.watch('/all/messages');
  }

  public allMessages(): Observable<string> {
    return this.rxStompService.watch('/all/messages').pipe(
      map((message) => {
        return message.body;
      })
    );
  }

  public privateMessages(): Observable<string> {
    return this.rxStompService.watch('/user/specific').pipe(
      map((message) => {
        return message.body;
      })
    );
  }

  public sendMessage(message: string) {
    this.rxStompService.publish({destination: "/app/application", body: message});
  }

  public sendPrivate(message: string) {
    this.rxStompService.publish({destination: "/app/private", body: message});
  }
  
}
