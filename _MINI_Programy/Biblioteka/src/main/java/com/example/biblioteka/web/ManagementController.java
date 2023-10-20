package com.example.biblioteka.web;

import com.example.biblioteka.ManagementService;
import com.example.biblioteka.booklending.CheckoutRequest;
import com.example.biblioteka.bookreservation.ReservationCancellationRequest;
import com.example.biblioteka.bookreservation.ReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class ManagementController {
    private final ManagementService managementService;

    @PostMapping("/reservation")
    public void reserveABook(@RequestBody ReservationRequest request) {
        managementService.reserveABook(request);
    }

    @PostMapping("/reservation/cancel")
    public void cancelAReservation(@RequestBody ReservationCancellationRequest request) {
        managementService.cancelReservation(request);
    }

    @PostMapping("/checkout")
    public void checkout(@RequestBody CheckoutRequest request) {
        managementService.checkout(request);
    }

    @PostMapping("/books/return")
    public void returnABook(String bookBarcode) {
        managementService.returnABook(bookBarcode);
    }

    @PostMapping("/books/renew")
    public void renewABook(String bookBarcode) {
        managementService.renewABook(bookBarcode);
    }


}
