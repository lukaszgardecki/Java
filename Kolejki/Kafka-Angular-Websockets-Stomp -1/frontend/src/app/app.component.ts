import { Component, OnDestroy, OnInit } from '@angular/core';
import { Message } from '@stomp/stompjs';
import { Subscription } from 'rxjs';
import { RxStompService } from './rx-stomp.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
  receivedMessages: string[] = [];
  // @ts-ignore, to suppress warning related to being undefined
  private topicSubscription: Subscription;

  constructor(private rxStompService: RxStompService) {}

  ngOnInit() {
    this.topicSubscription = this.rxStompService
      .watch('/all/messages')
      .subscribe((message: Message) => {
        this.receivedMessages.push(message.body);
      });
  }

  ngOnDestroy() {
    this.topicSubscription.unsubscribe();
  }

  onSendMessage() {
    const message = `Message generated at ${new Date()}`;
    this.rxStompService.publish({ destination: '/app/application', body: message });
  }

}
