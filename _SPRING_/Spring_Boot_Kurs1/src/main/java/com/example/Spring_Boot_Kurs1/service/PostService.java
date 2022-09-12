package com.example.Spring_Boot_Kurs1.service;

import com.example.Spring_Boot_Kurs1.model.Post;
import com.example.Spring_Boot_Kurs1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }
}
