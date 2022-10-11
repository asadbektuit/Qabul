package com.example.qabul.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("users"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("F-I-SH"))
    private String fish;

    private String tel;

    @Column(name = ("passport_number"))
    private String passportNumber;

    @ManyToOne
    @JoinColumn(name = ("organization_id"), insertable = false, updatable = false)
    private Organization organization;

    @Column(name = ("organization_id"))
    private Integer organizationId;

    @ManyToOne
    @JoinColumn(name = ("degree_id"), insertable = false, updatable = false)
    private Degree degree;

    @Column(name = ("degree_id"))
    private Integer degreeId;

    private String mutaxasislik;

    private String lavozim;

    @ManyToOne
    @JoinColumn(name = ("sport_razryad_va_unvoni_id"), insertable = false, updatable = false)
    private SportRazryadVaUnvoni sportRazryadVaUnvoni;

    @Column(name = ("sport_razryad_va_unvoni_id"))
    private Integer sportRazryadVaUnvoniId;

    @ManyToOne
    @JoinColumn(name = ("study_type_id"), insertable = false, updatable = false)
    private StudyType studyType;

    @Column(name = ("study_type_id"))
    private Integer studyTypeId;

    @ManyToOne
    @JoinColumn(name = ("study_form_id"), insertable = false, updatable = false)
    private StudyForm studyForm;

    @Column(name = ("study_form_id"))
    private Integer studyFormId;

    @ManyToOne
    @JoinColumn(name = ("education_language_id"), insertable = false, updatable = false)
    private EducationLanguage educationLanguage;

    @Column(name = ("education_language_id"))
    private Integer educationLanguageId;

    @ManyToOne
    @JoinColumn(name = ("residential_id"), insertable = false, updatable = false)
    private Residential residential;

    @Column(name = ("residential_id"))
    private Integer residentialId;

    @ManyToOne
    @JoinColumn(name = ("retraining_course_id"), insertable = false, updatable = false)
    private RetrainingCourse retrainingCourse;

    @Column(name = ("retraining_course_id"))
    private Integer retrainingCourseId;

    @ManyToOne
    @JoinColumn(name = ("study_place_id"), insertable = false, updatable = false)
    private StudyPlace studyPlace;

    @Column(name = ("study_place_id"))
    private Integer studyPlaceId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;

}
