package com.example.qabul.repository;

import com.example.qabul.entity.StartingMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StartingMonthRepository extends JpaRepository<StartingMonth,Integer> {


    Optional<StartingMonth> findByIdAndDeletedAtIsNull(Integer id);
}
