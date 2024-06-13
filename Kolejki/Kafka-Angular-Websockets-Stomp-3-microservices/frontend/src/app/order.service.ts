import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrderDetails } from './orderdetails';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseURL = "http://localhost:9191"

  constructor(private http: HttpClient) { }

  placeOrder(order: OrderDetails): Observable<any> {
    return this.http.post(`${this.baseURL}/save`, order);
  }
}
