package com.souvik.service;

import com.souvik.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CourseService {

    private List<Course> coursesDatabase = new ArrayList<Course>();

    // create course object in db
    public Course onboardNewCourse(Course course){
        course.setCourseId(new Random().nextInt(2346));
        coursesDatabase.add(course);
        return  course;
    }

    //load all course from database
    public List<Course> viewAllCourses(){
        return coursesDatabase;
    }





}
