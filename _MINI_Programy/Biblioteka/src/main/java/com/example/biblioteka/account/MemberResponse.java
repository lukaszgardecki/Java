package com.example.biblioteka.account;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class MemberResponse {
    private Long id;
    private LocalDate dateOfMembership;
    private int totalBooksCheckedout;
    private int totalBooksReserved;
}
