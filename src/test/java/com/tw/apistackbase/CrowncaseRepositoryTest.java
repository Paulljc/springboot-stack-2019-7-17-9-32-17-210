package com.tw.apistackbase;

import com.tw.apistackbase.entity.Crowncase;
import com.tw.apistackbase.repository.CrowncaseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

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

    @Test
    public void should_return_cases_when_find_all_order_by_case_time() {
        List<Crowncase> happen_time = crowncaseRepository.findAll(new Sort(Sort.Direction.ASC, "caseTime"));
        System.out.println(happen_time.toString());
    }

    @Test
    public void should_equal_size_when_find_by_name() {
        List<Crowncase> result = crowncaseRepository.findAllByCaseName("murder");
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void should_return_cases_when_find_by_name() {
        List<Crowncase> before = crowncaseRepository.findAll();
        crowncaseRepository.deleteById(3l);
        List<Crowncase> after = crowncaseRepository.findAll();
        Assertions.assertSame(1, before.size() - after.size());
    }
}
