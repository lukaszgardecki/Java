import { Component } from "@angular/core";
import { WebSocketService } from "./services/web-socket.service";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
  })
  export class AppComponent {
    isConnected: boolean = false;


    constructor(
      private webSocketService: WebSocketService
    ) {
      webSocketService.isConnected$.subscribe({
        next: isConnected => this.isConnected = isConnected
      });
    }
  }