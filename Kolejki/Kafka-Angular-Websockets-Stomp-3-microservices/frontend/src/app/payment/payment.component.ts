import { Component } from '@angular/core';
import { WebSocketService } from '../web-socket.service';

@Component({
  selector: 'app-payment',
  standalone: true,
  imports: [],
  templateUrl: './payment.component.html',
  styleUrl: './payment.component.css',
  providers: [
    WebSocketService
  ]
})
export class PaymentComponent {
  message: any;

  constructor(private webSocketService: WebSocketService) {
    let stompclient = webSocketService.initWebsocket();
    stompclient.connect({}, (frame: any) => {
      stompclient.subscribe("/ordertopic/hello", (notification: any) => {
        console.log(notification);
        this.message = notification.body;
      })
    })
  }
}
