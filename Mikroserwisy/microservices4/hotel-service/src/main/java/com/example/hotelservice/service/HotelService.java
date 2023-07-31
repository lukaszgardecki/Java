package com.example.hotelservice.service;

import com.example.hotelservice.entity.Hotel;
import com.example.hotelservice.exception.ResourceNotFoundException;
import com.example.hotelservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public Hotel getSingleHotel(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with id %s not found".formatted(id)));
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
