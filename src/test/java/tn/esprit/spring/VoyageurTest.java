/*package tn.esprit.spring;




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
import tn.esprit.spring.repository.VoyageurRepository;
import tn.esprit.spring.services.VoyageurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;





@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class VoyageurTest {

    @Mock
    VoyageurRepository voyageurRepository;

    @InjectMocks
    VoyageurServiceImpl voyageurService;
    List<Voyageur> voyageurs = new ArrayList<Voyageur>() {
        {
            add(new Voyageur());

        }

    };




    @Test
    void addVoyageurTest()
    {
       // Voyageur voyageur = new Voyageur();
      /*  for (Voyageur v : voyageurs)
        {
            voyageurService.ajouterVoyageur(v);
            verify(voyageurRepository, times(1)).save(v);

        }
        Voyageur v1 = new Voyageur();

        v1.setIdVoyageur(1L);
        v1.setNomVoyageur("Skander");

        verify(voyageurRepository).save(v1);





    }




}
*/