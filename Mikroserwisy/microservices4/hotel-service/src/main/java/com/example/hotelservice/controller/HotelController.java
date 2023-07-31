package com.example.hotelservice.controller;

import com.example.hotelservice.entity.Hotel;
import com.example.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_internal')")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable Long id) {
        Hotel singleHotel = hotelService.getSingleHotel(id);
        return ResponseEntity.ok(singleHotel);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    public ResponseEntity<List<Hotel>> getAll() {
        List<Hotel> hotels = hotelService.getAll();
        return ResponseEntity.ok(hotels);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.create(hotel);
        URI createdHotelLink = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdHotel.getId())
                .toUri();
        return ResponseEntity.created(createdHotelLink).body(createdHotel);
    }
}
