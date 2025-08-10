package com.souvik.service;

import com.souvik.dto.CourseRequestDTO;
import com.souvik.dto.CourseResponseDTO;
import com.souvik.entity.CourseEntity;
import com.souvik.repository.CourseDao;
import com.souvik.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.souvik.util.AppUtils.*;

@Service
@AllArgsConstructor
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    // create course object in db -> post
    public CourseResponseDTO onboardNewCourse(CourseRequestDTO courseRequestDTO){
        CourseEntity courseEntity = AppUtils.mapDtoToEntity(courseRequestDTO);
        CourseEntity entity = courseDao.save(courseEntity);
        CourseResponseDTO courseResponseDTO = courseEntityToDto(entity);
        courseResponseDTO.setCourseUniqueCode(UUID.randomUUID().toString().split("-")[0]);
        return courseResponseDTO;
    }

    //load all course from database -> get
    public List<CourseResponseDTO> viewAllCourses(){
        Iterable<CourseEntity> courseEntities = courseDao.findAll();
        return StreamSupport.stream(courseEntities.spliterator(),false)
                                            .map(AppUtils::courseEntityToDto)
                                            .collect(Collectors.toList());

    }

    //find specific course by id  -> get
    public CourseResponseDTO findByCourseId(Integer courseId){
        CourseEntity courseEntity = courseDao.findById(courseId).orElseThrow(() -> new RuntimeException(courseId+" not valid..."));
        return AppUtils.courseEntityToDto(courseEntity);
    }

    //delete course  -> delete
    public void deleteCourse(Integer courseId){
        courseDao.deleteById(courseId);
    }

    //update course  -> put
    public CourseResponseDTO updateCourse(Integer courseId, CourseRequestDTO courseRequestDTO){
        CourseEntity courseEntity = courseDao.findById(courseId).orElse(null);
        courseEntity.setCourseName(courseRequestDTO.getCourseName());
        courseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        courseEntity.setDuration(courseRequestDTO.getDuration());
        courseEntity.setStartDate(courseRequestDTO.getStartDate());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        CourseEntity updatedCourseEntity = courseDao.save(courseEntity);
        return AppUtils.courseEntityToDto(updatedCourseEntity);
    }



}
