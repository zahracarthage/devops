package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.repository.VoyageRepository;
import tn.esprit.spring.repository.VoyageurRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainServiceImpl implements ITrainService {


    @Autowired
    VoyageurRepository voyageurRepository;


    @Autowired
    TrainRepository trainRepository;

    @Autowired
    VoyageRepository voyageRepository;

    private static final Logger logger = LogManager.getLogger(TrainServiceImpl.class);


    public void ajouterTrain(Train t) {

        trainRepository.save(t);
    }

    public int TrainPlacesLibres(Ville nomGareDepart) {
        int cpt = 0;
        int occ = 0;
        List<Voyage> listvoyage = (List<Voyage>) voyageRepository.findAll();
        logger.log(logger.getLevel(),"tailee {0}", listvoyage.size());

        for (int i = 0; i < listvoyage.size(); i++) {
            logger.log(logger.getLevel(), "gare {0} value {1}", nomGareDepart, listvoyage.get(0).getGareDepart());
            if (listvoyage.get(i).getGareDepart() == nomGareDepart) {
                cpt = cpt + listvoyage.get(i).getTrain().getNbPlaceLibre();
                occ = occ + 1;
                logger.log(logger.getLevel(), "cpt {0}", cpt);
            }
        }
        return cpt / occ;
    }


    public List<Train> ListerTrainsIndirects(Ville nomGareDepart, Ville nomGareArrivee) {

        List<Train> lestrainsRes = new ArrayList<>();
        List<Voyage> lesvoyage;
        lesvoyage = (List<Voyage>) voyageRepository.findAll();
        for (int i = 0; i < lesvoyage.size(); i++) {
            if (lesvoyage.get(i).getGareDepart() == nomGareDepart) {
                for (Voyage voyage : lesvoyage) {
                    if (lesvoyage.get(i).getGareArrivee() == voyage.getGareDepart() && voyage.getGareArrivee() == nomGareArrivee) {
                        lestrainsRes.add(lesvoyage.get(i).getTrain());
                        lestrainsRes.add(voyage.getTrain());

                    }

                }
            }
        }


        return lestrainsRes;
        //
    }


    @Transactional
    public void affecterTainAVoyageur(Long idVoyageur, Ville nomGareDepart, Ville nomGareArrivee, double heureDepart) {


        logger.log(logger.getLevel(),"taille test");
        Voyageur c = voyageurRepository.findById(idVoyageur).get();
        List<Voyage> lesvoyages;
        lesvoyages = voyageRepository.RechercheVoyage(nomGareDepart, nomGareDepart, heureDepart);
        logger.log(logger.getLevel(),"taille {0}", lesvoyages.size());
        for (Voyage lesvoyage : lesvoyages) {
            if (lesvoyage.getTrain().getNbPlaceLibre() != 0) {
                lesvoyage.getMesVoyageurs().add(c);
                lesvoyage.getTrain().setNbPlaceLibre(lesvoyage.getTrain().getNbPlaceLibre() - 1);
            } else
                logger.log(logger.getLevel(), "Pas de place disponible pour {0}", voyageurRepository.findById(idVoyageur).get().getNomVoyageur());
            voyageRepository.save(lesvoyage);
        }
    }

    @Override
    public void desaffecterVoyageursTrain(Ville nomGareDepart, Ville nomGareArrivee, double heureDepart) {
        List<Voyage> lesvoyages;
        lesvoyages = voyageRepository.RechercheVoyage(nomGareDepart, nomGareArrivee, heureDepart);
        logger.log(logger.getLevel(),"taille {0}", lesvoyages.size());

        for (Voyage lesvoyage : lesvoyages) {
            for (int j = 0; j < lesvoyage.getMesVoyageurs().size(); j++)
                lesvoyage.getMesVoyageurs().remove(j);
            lesvoyage.getTrain().setNbPlaceLibre(lesvoyage.getTrain().getNbPlaceLibre() + 1);
            lesvoyage.getTrain().setEtat(etatTrain.prevu);
            voyageRepository.save(lesvoyage);
            trainRepository.save(lesvoyage.getTrain());
        }
    }

    @Scheduled(fixedRate = 2000)
    public void TrainsEnGare() {
        List<Voyage> lesvoyages;
        lesvoyages = (List<Voyage>) voyageRepository.findAll();
        logger.log(logger.getLevel(), "taille {0}", lesvoyages.size());

        Date date = new Date();
        logger.log(logger.getLevel(),"In Schedular After Try");
        for (int i = 0; i < lesvoyages.size(); i++) {
            if (lesvoyages.get(i).getDateArrivee().before(date)) {
                logger.log(logger.getLevel(),"les trains sont {0}", lesvoyages.get(i).getTrain().getCodeTrain());
            }

        }
    }


}

    
