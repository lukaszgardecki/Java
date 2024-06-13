import { Injectable } from '@angular/core';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';

// var SockJS = require("sockjs-client");
// var Stomp = require("stompjs");

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {

  constructor() { }

  initWebsocket() {
    let sockjs = new SockJS("http://localhost:9292/websocketenv");
    let stompclient = Stomp.over(sockjs);
    return stompclient;
  }
}
