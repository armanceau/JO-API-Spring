package com.efrei.JO.dto;

import java.time.LocalDate;

import com.efrei.JO.model.*;

public class UpdateBillet {

	private Float prix;
	private LocalDate dateValidite;
    private Epreuve epreuve;
	private Personne personne;


	public UpdateBillet(Float prix, LocalDate dateValidite, Epreuve epreuve, Personne personne) {
		this.prix = prix;
		this.dateValidite = dateValidite;
		this.epreuve = epreuve;
		this.personne = personne;
	}

	public Float getPrix() {
		return prix;
	}

	public LocalDate getDateValidite() {
		return dateValidite;
	}

	public Epreuve getEpreuve(){
		return epreuve;
	}

	public Personne getPersonne(){
		return personne;
	}
}
