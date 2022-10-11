package com.example.qabul.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    private Integer id;
    private String fish;
    private String tel;
    private String passportNumber;
    private OrganizationDto organization;
    private Integer organizationId;
    private DegreeDto degree;
    private Integer degreeId;
    private String mutaxasislik;
    private String lavozim;
    private SportRazryadVaUnvoniDto sportRazryadVaUnvoni;
    private Integer sportRazryadVaUnvoniId;
    private StudyTypeDto studyType;
    private Integer studyTypeId;
    private StudyFormDto studyForm;
    private Integer studyFormId;
    private EducationLanguageDto educationLanguage;
    private Integer educationLanguageId;
    private ResidentialDto residential;
    private Integer residentialId;
    private RetrainingCourseDto retrainingCourse;
    private Integer retrainingCourseId;
    private StudyPlaceDto studyPlace;
    private Integer studyPlaceId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
