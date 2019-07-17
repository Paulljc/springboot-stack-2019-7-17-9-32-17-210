package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Crowncase;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrowncaseRepository extends JpaRepository<Crowncase, Long> {

    @Override
    List<Crowncase> findAll(Sort sort);

    List<Crowncase> findAllByCaseName(String name);

    @Override
    void deleteById(Long id);
}
