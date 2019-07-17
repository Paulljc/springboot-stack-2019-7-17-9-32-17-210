package com.tw.apistackbase;


import com.tw.apistackbase.entity.CrownDetail;
import com.tw.apistackbase.repository.CrownDetailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrownDetailRepositoryTest {

    @Autowired
    private CrownDetailRepository detailRepository;

    @Test
    public void should_return_case_detail_when_find_case_by_id(){
        CrownDetail crownDetail = detailRepository.findById(2l).get();
        Assertions.assertNotNull(crownDetail);
    }
}
