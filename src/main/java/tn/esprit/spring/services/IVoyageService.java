package tn.esprit.spring.services;

import tn.esprit.spring.entities.Voyage;

import java.util.List;

public interface IVoyageService {

	 void ajouterVoyage(Voyage v);
	 void modifierVoyage(Voyage v);
	 void affecterTrainAVoyage(Long idTrain, Long idVoyage);
	 List<Voyage> recupererAll();
	 Voyage recupererVoyageParId(long idVoyage);
	 void supprimerVoyage(Voyage v);

	
}
