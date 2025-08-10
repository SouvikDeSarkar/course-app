package com.souvik.util;

import com.souvik.dto.CourseRequestDTO;
import com.souvik.dto.CourseResponseDTO;
import com.souvik.entity.CourseEntity;

public class AppUtils {

    public static CourseEntity mapDtoToEntity(CourseRequestDTO courseRequestDTO) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setEmail(courseRequestDTO.getEmail());
        courseEntity.setContact(courseRequestDTO.getContact());
        courseEntity.setCourseName(courseRequestDTO.getCourseName());
        courseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        courseEntity.setDuration(courseRequestDTO.getDuration());
        courseEntity.setStartDate(courseRequestDTO.getStartDate());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        return courseEntity;


    }

    public static CourseResponseDTO courseEntityToDto(CourseEntity entity) {
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setEmail(entity.getEmail());
        courseResponseDTO.setContact(entity.getContact());
        courseResponseDTO.setCourseId(entity.getCourseId());
        courseResponseDTO.setCourseName(entity.getCourseName());
        courseResponseDTO.setTrainerName(entity.getTrainerName());
        courseResponseDTO.setDuration(entity.getDuration());
        courseResponseDTO.setStartDate(entity.getStartDate());
        courseResponseDTO.setCourseType(entity.getCourseType());
        courseResponseDTO.setFees(entity.getFees());
        courseResponseDTO.setCertificateAvailable(entity.isCertificateAvailable());
        courseResponseDTO.setDescription(entity.getDescription());
        return courseResponseDTO;

    }

}
