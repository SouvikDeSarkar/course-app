package com.souvik.controller;


import com.souvik.dto.CourseRequestDTO;
import com.souvik.dto.CourseResponseDTO;
import com.souvik.dto.ServiceResponse;
import com.souvik.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/addCourse")
    public ServiceResponse<CourseResponseDTO> addCourse(@RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO course1 = courseService.onboardNewCourse(courseRequestDTO);
        return new ServiceResponse<CourseResponseDTO>(HttpStatus.CREATED, course1);
    }

    @GetMapping("/allCourses")
    public ServiceResponse<List<CourseResponseDTO>> findAllCourse(){
        List<CourseResponseDTO> courseResponseDTOS = courseService.viewAllCourses();
        return new ServiceResponse<>(HttpStatus.OK,courseResponseDTOS);
    }

    @GetMapping("/search/{courseId}")
    public ServiceResponse<CourseResponseDTO> findCourse(@PathVariable Integer courseId){
        return new ServiceResponse<>(HttpStatus.OK, courseService.findByCourseId(courseId));
    }

    @GetMapping("/search")
    public ServiceResponse<CourseResponseDTO> findCourseRequestParam(@RequestParam(required = false) Integer courseId){
        return new ServiceResponse<>(HttpStatus.OK, courseService.findByCourseId(courseId));
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer courseId){
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(" ", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{courseId}")
    public ServiceResponse<CourseResponseDTO> updateCourse(@PathVariable Integer courseId, @RequestParam CourseRequestDTO courseRequestDTO){
        return new ServiceResponse<>(HttpStatus.OK, courseService.updateCourse(courseId,courseRequestDTO));
    }

}
