package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.etatTrain;
import tn.esprit.spring.services.ITrainService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TrainTest {

    @Autowired
    ITrainService trainService;
  

    @Test
    void addTrainTest() {
        Train train = new Train();
        List<Train> trainList = new ArrayList<>();
        for (Long i=1L;i<=5L;i++) {
          train.setIdTrain(i);
          train.setCodeTrain(5L);
          train.setEtat(etatTrain.en_gare);
          train.setNbPlaceLibre(34);
            trainService.ajouterTrain(train);
            trainList.add(train);
        }
        assertEquals(5,trainList.size());
    }











}
