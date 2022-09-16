package com.example.Spring_Boot_Kurs2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TalkRepository extends JpaRepository<Talk, String> {

}
