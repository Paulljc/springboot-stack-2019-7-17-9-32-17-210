package com.tw.apistackbase;

import com.tw.apistackbase.entity.Crowncase;
import com.tw.apistackbase.repository.CrowncaseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrowncaseRepositoryTest {

    @Autowired
    private CrowncaseRepository crowncaseRepository;

    @Test
    public void should_return_case_when_find_by_id() {
        Crowncase crowncase = new Crowncase("murder", new Date());

        Crowncase savedCase = crowncaseRepository.saveAndFlush(crowncase);

        Assertions.assertNotNull(crowncaseRepository.findById(savedCase.getId()));
    }


}
