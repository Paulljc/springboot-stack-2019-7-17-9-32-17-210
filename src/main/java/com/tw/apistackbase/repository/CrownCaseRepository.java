package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CrownCase;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrownCaseRepository extends JpaRepository<CrownCase, Long> {

    @Override
    List<CrownCase> findAll(Sort sort);

    List<CrownCase> findAllByCaseName(String name);

    @Override
    void deleteById(Long id);

    CrownCase findCrownDetailById(Long id);
}
