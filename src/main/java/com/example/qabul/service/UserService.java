package com.example.qabul.service;

import com.example.qabul.dto.UserDto;
import com.example.qabul.entity.User;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    public boolean update(Integer id, UserDto dto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }

    public User getEntity(Integer id){
        Optional<User> optional = userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("User not found");
        }
        return optional.get();
    }
}
