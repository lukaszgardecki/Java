package com.example.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        //return courses;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
//        for (int i = 0; i < topics.size(); i++) {
//            Course t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, course);
//                return;
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }

}
