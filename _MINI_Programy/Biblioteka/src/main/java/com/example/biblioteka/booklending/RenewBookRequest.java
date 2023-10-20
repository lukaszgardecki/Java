package com.example.biblioteka.booklending;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RenewBookRequest {
    private Long userId;
    private Long bookId;
}
