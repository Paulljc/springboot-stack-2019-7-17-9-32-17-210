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

import java.util.List;

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
    public void should_return_procurator_when_find_procurator_by_id() {
        Prosecutor prosecutor = new Prosecutor("white");
        Prosecutor prosecutorInDB = prosecutorRepository.save(prosecutor);

        prosecutorInDB = prosecutorRepository.findById(prosecutorInDB.getId()).get();

        Assertions.assertEquals(prosecutor, prosecutorInDB);
    }

    @Test
    public void should_return_procurator_when_add_procurator(){
        Prosecutor procurator = new Prosecutor("zha");
        Prosecutor procuratorInDB = prosecutorRepository.save(procurator);

        procuratorInDB = prosecutorRepository.findById(procuratorInDB.getId()).get();

        Assertions.assertEquals(procurator, procuratorInDB);
        Assertions.assertEquals(procurator.getName(), procuratorInDB.getName());
    }

    @Test
    public void should_return_procurator_when_delete_procurator(){
        Prosecutor prosecutor1 = new Prosecutor("when");
        Prosecutor prosecutor2 = new Prosecutor("what");
        prosecutorRepository.save(prosecutor1);
        prosecutorRepository.save(prosecutor2);

        prosecutorRepository.deleteById(prosecutor1.getId());

        List<Prosecutor> allProsecutor = prosecutorRepository.findAll();
        Assertions.assertEquals(1, allProsecutor.size());
        Assertions.assertFalse(allProsecutor.contains(prosecutor1));
    }

    @Test
    public void should_return_procurator_when_update_procurator(){
        Prosecutor procurator = new Prosecutor("zha");
        prosecutorRepository.save(procurator);

        procurator.setName("oocl");
        Prosecutor procuratorInDB = prosecutorRepository.saveAndFlush(procurator);

        Assertions.assertEquals(procurator, procuratorInDB);
        Assertions.assertEquals(procurator.getName(), procuratorInDB.getName());
    }
}
