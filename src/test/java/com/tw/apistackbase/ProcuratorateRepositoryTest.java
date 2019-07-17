package com.tw.apistackbase;


import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcuratorateRepositoryTest {

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    public void should_return_the_procuratorate_when_get_procuratorate_by_id() {
        Procuratorate procuratorate = new Procuratorate("zha");
        Procuratorate saveProcuratorate = procuratorateRepository.save(procuratorate);

        saveProcuratorate = procuratorateRepository.findById(saveProcuratorate.getId()).get();

        Assertions.assertEquals(procuratorate, saveProcuratorate);
    }
}
