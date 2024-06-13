import { Component } from '@angular/core';
import { OrderService } from '../order.service';
import { HttpClient, HttpClientModule, HttpHandler } from '@angular/common/http';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [HttpClientModule],
  providers: [OrderService, HttpClient],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {

  constructor(private orderService: OrderService) {

  }

  placeOrder(id: number, product: string, status: string, price: number) {
    let order = {
      id: id,
      product: product,
      status: status,
      price: price
    }
    this.orderService.placeOrder(order).subscribe({
      next: order => {
        console.log("Order placed.")
      }
    });
  }
}
