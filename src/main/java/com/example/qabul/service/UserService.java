package com.example.qabul.service;

import com.example.qabul.dto.UserDto;
import com.example.qabul.entity.User;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    private OrganizationService organizationService;

    private DegreeService degreeService;

    private SportRazryadVaUnvoniService sportRazryadVaUnvoniService;

    private StudyTypeService studyTypeService;

    private StudyFormService studyFormService;

    private EducationLanguageService educationLanguageService;

    private ResidentialService residentialService;

    private RetrainingCourseService retrainingCourseService;

    private StudyPlaceService studyPlaceService;


    public UserDto get(Integer id) {
        User user = getEntity(id);
        UserDto dto = new UserDto();
        dto.setFish(user.getFish());
        dto.setTel(user.getTel());
        dto.setPassportNumber(user.getPassportNumber());
        dto.setMutaxasislik(user.getMutaxasislik());
        dto.setLavozim(user.getLavozim());
        dto.setOrganization(organizationService.get(dto.getOrganizationId()));
        dto.setDegree(degreeService.get(dto.getDegreeId()));
        dto.setSportRazryadVaUnvoni(sportRazryadVaUnvoniService.get(dto.getSportRazryadVaUnvoniId()));
        dto.setStudyType(studyTypeService.get(dto.getStudyTypeId()));
        dto.setStudyForm(studyFormService.get(dto.getStudyFormId()));
        dto.setEducationLanguage(educationLanguageService.get(dto.getEducationLanguageId()));
        dto.setResidential(residentialService.get(dto.getResidentialId()));
        dto.setRetrainingCourse(retrainingCourseService.get(dto.getRetrainingCourseId()));
        dto.setStudyPlace(studyPlaceService.get(dto.getStudyPlaceId()));
        return dto;
    }

    public UserDto create(UserDto dto) {
        User user = new User();

        //TODO: check degree
        degreeService.getEntity(dto.getDegreeId());
        user.setDegreeId(dto.getDegreeId());

        //TODO: check sport razryad va unvoni
        sportRazryadVaUnvoniService.getEntity(dto.getSportRazryadVaUnvoniId());
        user.setSportRazryadVaUnvoniId(dto.getSportRazryadVaUnvoniId());

        //TODO: check study form
        studyFormService.getEntity(dto.getStudyFormId());
        user.setStudyFormId(dto.getStudyFormId());

        //TODO: check study type
        studyTypeService.getEntity(dto.getStudyTypeId());
        user.setStudyTypeId(dto.getStudyTypeId());

        //TODO: check education language
        educationLanguageService.getEntity(dto.getEducationLanguageId());
        user.setEducationLanguageId(dto.getEducationLanguageId());

        //TODO: check residential
        residentialService.getEntity(dto.getResidentialId());
        user.setResidentialId(dto.getResidentialId());

        //TODO: check retraining
        retrainingCourseService.getEntity(dto.getRetrainingCourseId());
        user.setRetrainingCourseId(dto.getRetrainingCourseId());

        //TODO: check study place
        studyPlaceService.getEntity(dto.getStudyPlaceId());
        user.setStudyPlaceId(dto.getStudyPlaceId());

        //TODO: check organization
        organizationService.getEntity(dto.getOrganizationId());
        user.setOrganizationId(dto.getOrganizationId());

        user.setFish(dto.getFish());
        user.setTel(dto.getTel());
        user.setPassportNumber(dto.getPassportNumber());
        user.setMutaxasislik(dto.getMutaxasislik());
        user.setLavozim(dto.getLavozim());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        return dto;
    }

    public boolean update(Integer id, UserDto dto) {
        User user = getEntity(id);

        //TODO: check degree
        degreeService.getEntity(dto.getDegreeId());
        user.setDegreeId(dto.getDegreeId());

        //TODO: check sport razryad va unvoni
        sportRazryadVaUnvoniService.getEntity(dto.getSportRazryadVaUnvoniId());
        user.setSportRazryadVaUnvoniId(dto.getSportRazryadVaUnvoniId());

        //TODO: check study form
        studyFormService.getEntity(dto.getStudyFormId());
        user.setStudyFormId(dto.getStudyFormId());

        //TODO: check study type
        studyTypeService.getEntity(dto.getStudyTypeId());
        user.setStudyTypeId(dto.getStudyTypeId());

        //TODO: check education language
        educationLanguageService.getEntity(dto.getEducationLanguageId());
        user.setEducationLanguageId(dto.getEducationLanguageId());

        //TODO: check residential
        residentialService.getEntity(dto.getResidentialId());
        user.setResidentialId(dto.getResidentialId());

        //TODO: check retraining
        retrainingCourseService.getEntity(dto.getRetrainingCourseId());
        user.setRetrainingCourseId(dto.getRetrainingCourseId());

        //TODO: check study place
        studyPlaceService.getEntity(dto.getStudyPlaceId());
        user.setStudyPlaceId(dto.getStudyPlaceId());

        user.setFish(dto.getFish());
        user.setTel(dto.getTel());
        user.setPassportNumber(dto.getPassportNumber());
        user.setMutaxasislik(dto.getMutaxasislik());
        user.setLavozim(dto.getLavozim());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return true;
    }

    public boolean delete(Integer id) {
        User user = getEntity(id);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
        return true;
    }

    public User getEntity(Integer id){
        Optional<User> optional = userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("User not found");
        }
        return optional.get();
    }
}
