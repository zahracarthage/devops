package tn.esprit.spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity 
public class Voyageur implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoyageur;
	
	String nomVoyageur;

	
	public List<Voyage> getMesvoyages() {
		return mesvoyages;
	}

	public void setMesvoyages(List<Voyage> mesvoyages) {
		this.mesvoyages = mesvoyages;
	}

	@ManyToMany(mappedBy = "mesVoyageurs")
    private List<Voyage> mesvoyages;

	public Long getIdVoyageur() {
		return idVoyageur;
	}

	public void setIdVoyageur(Long idVoyageur) {
		this.idVoyageur = idVoyageur;
	}

	public String getNomVoyageur() {
		return nomVoyageur;
	}

	public void setNomVoyageur(String nomVoyageur) {
		this.nomVoyageur = nomVoyageur;
	}

	public Voyageur() {
		super();
	}
	
	
}
