package com.tw.apistackbase;

import com.tw.apistackbase.entity.CrownCase;
import com.tw.apistackbase.entity.CrownDetail;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repository.CrownCaseRepository;
import com.tw.apistackbase.repository.CrownDetailRepository;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CrownCaseRepositoryTest {

    @Autowired
    private CrownCaseRepository crowncaseRepository;
    @Autowired
    private ProcuratorateRepository procuratorateRepository;
    @Autowired
    private CrownDetailRepository crownDetailRepository;

    @BeforeEach
    public void clearDB(){
        crowncaseRepository.deleteAll();
    }

//    private Procuratorate procuratorate = new Procuratorate("zha");

    @Test
    public void should_return_case_when_add_case() {
        Procuratorate procuratorate = new Procuratorate("zha");
        procuratorateRepository.saveAndFlush(procuratorate);

        CrownDetail crownDetail = new CrownDetail("objective", "subjective");
        crownDetailRepository.saveAndFlush(crownDetail);

        CrownCase crowncase = new CrownCase("murder", new Date().getTime(), crownDetail, procuratorate);
        CrownCase crowncaseInDB = crowncaseRepository.saveAndFlush(crowncase);

        Assertions.assertEquals(crowncase, crowncaseInDB);
    }

    @Test
    public void should_return_case_when_find_case_by_id() {
        Procuratorate procuratorate = new Procuratorate("zha");
        procuratorateRepository.saveAndFlush(procuratorate);

        CrownCase crowncase = new CrownCase("murder", new Date().getTime(), null, procuratorate);

        CrownCase crowncaseInDB = crowncaseRepository.saveAndFlush(crowncase);
        crowncaseInDB = crowncaseRepository.findById(crowncaseInDB.getId()).get();

        Assertions.assertEquals(crowncase, crowncaseInDB);
    }

    @Test
    public void should_return_case_when_update_case() {
        Procuratorate procuratorate = new Procuratorate("zha");
        procuratorateRepository.saveAndFlush(procuratorate);

        CrownCase crowncase = new CrownCase("murder", new Date().getTime(), null, procuratorate);
        crowncaseRepository.saveAndFlush(crowncase);

        crowncase.setCaseName("fight");
        CrownCase crowncaseInDB = crowncaseRepository.saveAndFlush(crowncase);
        crowncaseInDB = crowncaseRepository.findById(crowncaseInDB.getId()).get();

        Assertions.assertEquals(crowncase, crowncaseInDB);
        Assertions.assertEquals(crowncase.getCaseName(), crowncaseInDB.getCaseName());
    }


    @Test
    public void should_return_cases_when_delete_case_by_id() {
        Procuratorate procuratorate = new Procuratorate("zha");
        procuratorateRepository.saveAndFlush(procuratorate);

        CrownCase crownCase1 = new CrownCase("case1", new Date().getTime(), null, procuratorate);
        CrownCase crownCase2 = new CrownCase("case2", new Date().getTime(), null, procuratorate);
        crowncaseRepository.save(crownCase1);
        crowncaseRepository.save(crownCase2);

        crowncaseRepository.deleteById(crownCase1.getId());;

        List<CrownCase> allCases = crowncaseRepository.findAll();
        Assertions.assertEquals(1, allCases.size());
        Assertions.assertFalse(allCases.contains(crownCase1));
    }

    @Test
    public void should_return_cases_when_find_all_order_by_case_time() {
        Procuratorate procuratorate = new Procuratorate("zha");
        procuratorateRepository.saveAndFlush(procuratorate);

        List<CrownCase> criminalCases = Arrays.asList(
                new CrownCase("case1", new Date().getTime() - 1000, null, procuratorate),
                new CrownCase("case2", new Date().getTime() , null, procuratorate)
        );
        crowncaseRepository.saveAll(criminalCases);

        List<CrownCase> orderCrownCases = crowncaseRepository.findByOrderByCaseTimeDesc();

        Assertions.assertEquals(criminalCases.get(0), orderCrownCases.get(1));
        Assertions.assertEquals(criminalCases.get(1), orderCrownCases.get(0));
    }

    @Test
    public void should_return_all_case_when_find_case_by_name() {
        Procuratorate procuratorate = new Procuratorate("zha");
        procuratorateRepository.saveAndFlush(procuratorate);

        List<CrownCase> crownCases = Arrays.asList(
                new CrownCase("case1", new Date().getTime(), null, procuratorate),
                new CrownCase("case2", new Date().getTime(), null, procuratorate)
        );
        crowncaseRepository.saveAll(crownCases);

        List<CrownCase> result = crowncaseRepository.findAllByCaseName("case1");

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(crownCases.get(0)));
    }

}
