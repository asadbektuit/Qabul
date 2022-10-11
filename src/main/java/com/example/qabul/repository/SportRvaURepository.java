package com.example.qabul.repository;

import com.example.qabul.entity.SportRazryadVaUnvoni;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SportRvaURepository extends JpaRepository<SportRazryadVaUnvoni, Integer> {


    Optional<SportRazryadVaUnvoni> findByIdAndDeletedAtIsNull(Integer id);

}
