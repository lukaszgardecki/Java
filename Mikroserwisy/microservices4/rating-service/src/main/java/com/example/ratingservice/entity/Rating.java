package com.example.ratingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_ratings")
public class Rating {
    @Id
    private String id;
    private Long userId;
    private Long hotelId;
    private int rating;
    private String feedback;
}
