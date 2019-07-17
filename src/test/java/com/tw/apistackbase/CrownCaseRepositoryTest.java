package com.tw.apistackbase;

import com.tw.apistackbase.entity.CrownCase;
import com.tw.apistackbase.repository.CrownCaseRepository;
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
public class CrownCaseRepositoryTest {

    @Autowired
    private CrownCaseRepository crowncaseRepository;

    @Test
    public void should_return_case_when_find_by_id() {
        CrownCase crowncase = new CrownCase("murder", new Date());
        CrownCase savedCase = crowncaseRepository.saveAndFlush(crowncase);
        Assertions.assertNotNull(crowncaseRepository.findById(savedCase.getId()));
    }

    @Test
    public void should_return_cases_when_find_all_order_by_case_time() {
        List<CrownCase> happen_time = crowncaseRepository.findAll(new Sort(Sort.Direction.ASC, "caseTime"));
        System.out.println(happen_time.toString());
    }

    @Test
    public void should_equal_size_when_find_by_name() {
        List<CrownCase> result = crowncaseRepository.findAllByCaseName("murder");
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void should_return_cases_when_find_by_name() {
        List<CrownCase> before = crowncaseRepository.findAll();
        crowncaseRepository.deleteById(3l);
        List<CrownCase> after = crowncaseRepository.findAll();
        Assertions.assertSame(1, before.size() - after.size());
    }

    @Test
    public void should_get_case_when_get_detail_ID() {
        CrownCase crowncase = crowncaseRepository.findCrownDetailById(2l);
        Assertions.assertNotNull(crowncase);

        CrownCase crownCase = crowncaseRepository.findById(1l).get();
        Assertions.assertNotNull(crownCase);
    }
}
