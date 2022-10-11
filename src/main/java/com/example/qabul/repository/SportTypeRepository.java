package com.example.qabul.repository;
;
import com.example.qabul.entity.SportType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SportTypeRepository extends JpaRepository<SportType, Integer> {

    Optional<SportType> findByIdAndDeletedAtIsNull(Integer id);
}
