package com.souvik.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.souvik.annotation.CourseTypeValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDTO {


    @NotBlank(message = "Course name should not be empty")
    private String courseName;
    @NotEmpty(message = "Trainer name should be always defined")
    private String trainerName;
    @NotNull(message = "Duration must be specified")
    private String duration; //days
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    @Past(message = "Start date can not be before current date")
    private Date startDate;
    @CourseTypeValidation
    private String courseType; //live or recording
    @Min(value = 1500, message = "course price can not be less than 1500")
    @Max(value = 10000, message = "course price can not exceed 10000")
    private double fees;
    private boolean isCertificateAvailable;
    @NotEmpty(message = "Description must be present")
    private String description;
    @Email(message = "Invalid Email id")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$")
    private String contact;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public boolean isCertificateAvailable() {
        return isCertificateAvailable;
    }

    public void setCertificateAvailable(boolean certificateAvailable) {
        isCertificateAvailable = certificateAvailable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
