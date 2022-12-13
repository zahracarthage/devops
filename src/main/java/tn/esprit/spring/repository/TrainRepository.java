package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Train;




@Repository
public interface TrainRepository extends CrudRepository<Train, Long> {
	

	
//    @Query("select AVG(tr.nbPlaceLibre) from Train tr where tr.GareDepart.idGare=:idgd")
//    public int TrainPlacesLibres(@Param("idgd")Long idGareDepart);

}
