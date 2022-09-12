package com.example.Spring_Boot_Kurs1.repository;

import com.example.Spring_Boot_Kurs1.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
