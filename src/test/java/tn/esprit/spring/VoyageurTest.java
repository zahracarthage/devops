package tn.esprit.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repository.VoyageRepository;
import tn.esprit.spring.services.VoyageServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VoyageurTest {

    @Mock
    VoyageRepository voyageurRepository;

    @InjectMocks
    VoyageServiceImpl voyageurService;

    Voyageur voyageur = new Voyageur();



    @Test
    @Order(0)
    void addVoyageurTest()
    {
       // Voyageur voyageur = new Voyageur();
        voyageur.setIdVoyageur(1L);
        voyageur.setNomVoyageur("zahra");
        verify(voyageurRepository, times(1)).save(voyageur);


    }




}