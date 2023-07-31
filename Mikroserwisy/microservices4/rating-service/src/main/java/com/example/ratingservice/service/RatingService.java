package com.example.ratingservice.service;

import com.example.ratingservice.entity.Rating;
import com.example.ratingservice.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> getRatingsByHotelId(Long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }
}
