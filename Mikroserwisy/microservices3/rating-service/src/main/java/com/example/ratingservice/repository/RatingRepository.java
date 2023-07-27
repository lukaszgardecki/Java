package com.example.ratingservice.repository;

import com.example.ratingservice.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    List<Rating> findByUserId(Long userId);

    List<Rating> findByHotelId(Long hotelId);
}
