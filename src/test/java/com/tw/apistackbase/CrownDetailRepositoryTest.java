package com.tw.apistackbase;


import com.tw.apistackbase.entity.CrownCase;
import com.tw.apistackbase.entity.CrownDetail;
import com.tw.apistackbase.repository.CrownDetailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CrownDetailRepositoryTest {

    @Autowired
    private CrownDetailRepository detailRepository;

    @BeforeEach
    public void clearDB(){
        detailRepository.deleteAll();
    }

    @Test
    public void should_return_case_detail_when_find_case_detail_by_id(){
        CrownDetail crownDetail = new CrownDetail("objective", "subjective");
        CrownDetail crownDetailInDB = detailRepository.save(crownDetail);

        crownDetailInDB = detailRepository.findById(crownDetailInDB.getId()).get();

        Assertions.assertEquals(crownDetail, crownDetailInDB);
    }

    @Test
    public void should_return_case_detail_when_add_case_detail(){
        CrownDetail crownDetail = new CrownDetail("objective", "subjective");
        CrownDetail crownDetailInDB = detailRepository.save(crownDetail);

        crownDetailInDB = detailRepository.findById(crownDetailInDB.getId()).get();

        Assertions.assertEquals(crownDetail, crownDetailInDB);
    }

    @Test
    public void should_return_case_detail_when_delete_case_detail(){
        CrownDetail crownDetail1 = new CrownDetail("objective", "subjective");
        CrownDetail crownDetail2 = new CrownDetail("objective", "subjective");
        detailRepository.save(crownDetail1);
        detailRepository.save(crownDetail2);

        detailRepository.deleteById(crownDetail1.getId());

        List<CrownDetail> allCasesDetail = detailRepository.findAll();
        Assertions.assertEquals(1, allCasesDetail.size());
        Assertions.assertFalse(allCasesDetail.contains(crownDetail1));
    }

    @Test
    public void should_return_case_detail_when_update_case_detail(){
        CrownDetail crownDetail = new CrownDetail("objective", "subjective");
        detailRepository.save(crownDetail);

        crownDetail.setObjectiveCase("objective1");
        CrownDetail crowncaseDetailInDB = detailRepository.saveAndFlush(crownDetail);

        Assertions.assertEquals(crownDetail, crowncaseDetailInDB);
        Assertions.assertEquals(crownDetail.getObjectiveCase(), crowncaseDetailInDB.getObjectiveCase());
    }
}
