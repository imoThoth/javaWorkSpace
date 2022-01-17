package com.athena.experian.ModelTest;

import com.athena.experian.model.DataModel;
import com.athena.experian.model.DataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DataRespositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DataRepository dataRepository;

    @Test
    public void testSaveNewData(){
        entityManager.persist( new DataModel(
                1, "ExperianTest",
                LocalDateTime.now(), LocalDateTime.now(),1));

        DataModel data = dataRepository.findById(1).get();

        assertThat(data.getMsg_id()).isEqualTo(1);

    }

}
