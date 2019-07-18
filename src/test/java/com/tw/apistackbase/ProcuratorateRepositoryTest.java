package com.tw.apistackbase;


import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repository.ProcuratorateRepository;
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
public class ProcuratorateRepositoryTest {

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @BeforeEach
    public void clearDB(){
        procuratorateRepository.deleteAll();
    }

    @Test
    public void should_return_the_procuratorate_when_find_procuratorate_by_id() {
        Procuratorate procuratorate = new Procuratorate("zha");
        Procuratorate procuratorateInDB = procuratorateRepository.save(procuratorate);

        procuratorateInDB = procuratorateRepository.findById(procuratorateInDB.getId()).get();

        Assertions.assertEquals(procuratorate, procuratorateInDB);
    }

    @Test
    public void should_return_procuratorate_when_add_procuratorate(){
        Procuratorate procuratorate = new Procuratorate("zha");
        Procuratorate procuratorateInDB = procuratorateRepository.save(procuratorate);

        procuratorateInDB = procuratorateRepository.findById(procuratorateInDB.getId()).get();

        Assertions.assertEquals(procuratorate, procuratorateInDB);
        Assertions.assertEquals(procuratorate.getName(), procuratorateInDB.getName());
    }

    @Test
    public void should_return_procuratorate_when_delete_procuratorate(){
        Procuratorate procuratorate1 = new Procuratorate("when");
        Procuratorate procuratorate2 = new Procuratorate("what");
        procuratorateRepository.save(procuratorate1);
        procuratorateRepository.save(procuratorate2);

        procuratorateRepository.deleteById(procuratorate1.getId());

        List<Procuratorate> allProcuratorate = procuratorateRepository.findAll();
        Assertions.assertEquals(1, allProcuratorate.size());
        Assertions.assertFalse(allProcuratorate.contains(procuratorate1));
    }

    @Test
    public void should_return_case_detail_when_update_case_detail(){
        Procuratorate procuratorate = new Procuratorate("zha");
        procuratorateRepository.save(procuratorate);

        procuratorate.setName("oocl");
        Procuratorate procuratorateInDB = procuratorateRepository.saveAndFlush(procuratorate);

        Assertions.assertEquals(procuratorate, procuratorateInDB);
        Assertions.assertEquals(procuratorate.getName(), procuratorateInDB.getName());
    }
}
