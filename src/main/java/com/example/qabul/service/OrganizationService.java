package com.example.qabul.service;

import com.example.qabul.dto.DegreeDto;
import com.example.qabul.dto.OrganizationDto;
import com.example.qabul.entity.Degree;
import com.example.qabul.entity.Organization;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.DegreeRepository;
import com.example.qabul.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationDto get(Integer id) {
        Organization organization = getEntity(id);
        OrganizationDto dto = new OrganizationDto();
        dto.setName(organization.getName());;
        return dto;
    }
    public OrganizationDto create(OrganizationDto dto) {
        Organization organization = new Organization();
        organization.setName(dto.getName());
        organization.setCreatedAt(LocalDateTime.now());
        organizationRepository.save(organization);
        return dto;
    }
    public boolean update(Integer id, OrganizationDto dto) {
        Organization organization = getEntity(id);
        organization.setName(dto.getName());
        organization.setUpdatedAt(LocalDateTime.now());
        organizationRepository.save(organization);
        return true;
    }
    public boolean delete(Integer id) {
        Organization organization = getEntity(id);
        organization.setDeletedAt(LocalDateTime.now());
        organizationRepository.save(organization);
        return true;
    }
    private Organization getEntity(Integer id) {
        Optional<Organization> optional = organizationRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("Organization not found");
        }
        return optional.get();
    }
}
