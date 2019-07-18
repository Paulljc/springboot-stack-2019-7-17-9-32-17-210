package com.tw.apistackbase;

import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.entity.Prosecutor;
import com.tw.apistackbase.repository.ProsecutorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ProsecutorRepositoryTest {

    @Autowired
    private ProsecutorRepository prosecutorRepository;

    @BeforeEach
    public void clearDB(){
        prosecutorRepository.deleteAll();
    }

    @Test
    public void should_get_procurator_by_id() {
        Prosecutor prosecutor = new Prosecutor("sa");
        Prosecutor saveProsecutor= prosecutorRepository.save(prosecutor);

        saveProsecutor = prosecutorRepository.findById(saveProsecutor.getId()).get();

        Assertions.assertEquals(prosecutor, saveProsecutor);
    }
}
