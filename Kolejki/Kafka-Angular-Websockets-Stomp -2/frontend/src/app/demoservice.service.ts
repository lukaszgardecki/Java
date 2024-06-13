import { Injectable } from '@angular/core'; 
import {
  HttpClient,
  HttpHeaders,
} from '@angular/common/http'; 
import { BehaviorSubject } from 'rxjs';
import * as Stomp from 'stompjs';
import SockJS from 'sockjs-client';
@Injectable({
  providedIn: 'root'
})
export class DemoserviceService {
  apiUrl: string = 'http://localhost:8080/carsales/last30days';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  headers = new HttpHeaders().set('Content-Type', 'application/json');
  private _dataModel: BehaviorSubject<any> = new BehaviorSubject<any>({});
  private dataStore: { data: any } = { data: {} };
  readonly dataModel = this._dataModel.asObservable();
  
  constructor(private http: HttpClient) {
    this.streamCarSalesData();
  }
  
  getCarSalesData(){
    this.http.get(`${this.apiUrl}`).subscribe(data =>{
      this.dataStore.data = data;
      this._dataModel.next(Object.assign({}, this.dataStore).data);
    });     
  }
  streamURL: string = 'http://localhost:8080/websocket';
  client: any;
  streamMessage: any;
  
  streamCarSalesData(){
    let ws = new SockJS(this.streamURL);
    this.client = Stomp.over(ws);
    let that = this;
    this.client.connect({}, function(frame:any) {
        
      that.client.subscribe('/cars', (message:any) => {
        if(message.body) {
          that.streamMessage = message.body;
          that.dataStore.data = JSON.parse(that.streamMessage);
          that._dataModel.next(Object.assign({}, that.dataStore).data);
        }
      });
    });
  }   
}
