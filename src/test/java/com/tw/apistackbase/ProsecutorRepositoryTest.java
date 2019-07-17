package com.tw.apistackbase;

import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.entity.Prosecutor;
import com.tw.apistackbase.repository.ProsecutorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProsecutorRepositoryTest {

    @Autowired
    private ProsecutorRepository prosecutorRepository;

    @Test
    public void should_get_procurator_by_id() {
        Prosecutor prosecutor = new Prosecutor("sa");
        Prosecutor saveProsecutor= prosecutorRepository.save(prosecutor);

        saveProsecutor = prosecutorRepository.findById(saveProsecutor.getId()).get();

        Assertions.assertEquals(prosecutor, saveProsecutor);
    }
}
