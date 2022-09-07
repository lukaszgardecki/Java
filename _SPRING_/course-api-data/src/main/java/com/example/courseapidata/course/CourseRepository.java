package com.example.courseapidata.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Course t)
    //deleteTopic(String id)

    //tworząc interfejs, który rozszerza interfejs CrudRepository nie musimy tworzyć na nowo standaradowych metod, ponieważ interfejs CrudRepository JUŻ JE POSIADA.

    List<Course> findByTopicId(String topicId);
}

