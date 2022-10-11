package com.example.qabul.repository;

import com.example.qabul.entity.Degree;
import com.example.qabul.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    Optional<Organization> findByIdAndDeletedAtIsNull(Integer id);
}

