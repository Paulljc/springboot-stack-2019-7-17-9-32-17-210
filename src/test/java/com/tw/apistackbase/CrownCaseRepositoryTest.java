package com.tw.apistackbase;

import com.tw.apistackbase.entity.CrownCase;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repository.CrownCaseRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrownCaseRepositoryTest {

    @Autowired
    private CrownCaseRepository crowncaseRepository;

    @BeforeEach
    public void clearDB(){
        crowncaseRepository.deleteAll();
    }

    @Test
    public void should_return_case_when_find_case_by_id() {
        Procuratorate procuratorate = new Procuratorate("zha");
        CrownCase crowncase = new CrownCase("murder", new Date().getTime(), null, procuratorate);

        CrownCase savedCrownCase = crowncaseRepository.saveAndFlush(crowncase);
        savedCrownCase = crowncaseRepository.findById(savedCrownCase.getId()).get();

        Assertions.assertEquals(crowncase, savedCrownCase);
    }

    @Test
    public void should_return_cases_when_find_all_order_by_case_time() {
        Procuratorate procuratorate = new Procuratorate("zha");
        List<CrownCase> criminalCases = Arrays.asList(
                new CrownCase("case1", new Date().getTime(), null, procuratorate),
                new CrownCase("case2", new Date().getTime() - 1000, null, procuratorate)
        );
        crowncaseRepository.saveAll(criminalCases);

        List<CrownCase> orderCrownCases = crowncaseRepository.findAll(new Sort(Sort.Direction.ASC, "caseTime"));

        // then
        Assertions.assertEquals(criminalCases.get(1), orderCrownCases.get(0));
        Assertions.assertEquals(criminalCases.get(0), orderCrownCases.get(1));
    }

    @Test
    public void should_return_all_case_when_find_case_by_name() {
        Procuratorate procuratorate = new Procuratorate("zha");
        List<CrownCase> crownCases = Arrays.asList(
                new CrownCase("case1", new Date().getTime(), null, procuratorate),
                new CrownCase("case2", new Date().getTime(), null, procuratorate)
        );
        crowncaseRepository.saveAll(crownCases);

        List<CrownCase> result = crowncaseRepository.findAllByCaseName("case1");

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(crownCases.get(0)));
    }

    @Test
    public void should_return_cases_when_delete_case_by_id() {
        Procuratorate procuratorate = new Procuratorate("zha");
        CrownCase crownCase1 = new CrownCase("case1", new Date().getTime(), null, procuratorate);
        CrownCase crownCase2 = new CrownCase("case2", new Date().getTime(), null, procuratorate);
        crowncaseRepository.save(crownCase1);
        crowncaseRepository.save(crownCase2);

        crowncaseRepository.deleteById(crownCase1.getId());;

        List<CrownCase> allCases = crowncaseRepository.findAll();
        Assertions.assertEquals(1, allCases.size());
        Assertions.assertFalse(allCases.contains(crownCase1));
    }

}
