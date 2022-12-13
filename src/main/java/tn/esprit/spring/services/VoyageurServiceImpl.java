package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repository.VoyageurRepository;

import java.util.List;


@Service
public class VoyageurServiceImpl implements IVoyageurService{

	@Autowired
	VoyageurRepository voyageurRepository;

//	
//	private static final Logger l = LogManager.getLogger(voyageurServiceImpl.class);
//	
	public void ajouterVoyageur(Voyageur voyageur) {
		voyageurRepository.save(voyageur);
		
    }

	@Override
	public void modifierVoyageur(Voyageur voyageur) {
		voyageurRepository.save(voyageur);
	}
	private static final Logger logger = LogManager.getLogger(VoyageurServiceImpl.class);

	@Override
	public List<Voyageur> recupererAll() {
		List<Voyageur> list= (List<Voyageur>) voyageurRepository.findAll();
		for (Voyageur v: list) {
			logger.log(logger.getLevel(),"Voyageur");
			logger.log(logger.getLevel(),"voyageyr : {0}",v);
		}
		return list;
	}

	@Override
	public Voyageur recupererVoyageParId(long idVoyageur) {

		return null;
	}

	@Override
	public void supprimerVoyageur(Voyageur v) {
		voyageurRepository.delete(v);
	}

}
