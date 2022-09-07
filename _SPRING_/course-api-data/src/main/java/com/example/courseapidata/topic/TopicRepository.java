package com.example.courseapidata.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Course t)
    //deleteTopic(String id)

    //tworząc interfejs, który rozszerza interfejs CrudRepository nie musimy tworzyć na nowo standaradowych metod, ponieważ interfejs CrudRepository JUŻ JE POSIADA.

}
