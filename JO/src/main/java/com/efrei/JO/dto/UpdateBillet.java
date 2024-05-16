package com.efrei.JO.dto;

import java.time.LocalDate;

import com.efrei.JO.model.*;

public class UpdateBillet {

	private Float prix;
	private LocalDate dateValidite;
    private Epreuve epreuve;
	private Personne personne;
	private Billetterie billeterie;


	public UpdateBillet(Float prix, LocalDate dateValidite, Epreuve epreuve, Personne personne, Billetterie billeterie) {
		this.prix = prix;
		this.dateValidite = dateValidite;
		this.epreuve = epreuve;
		this.personne = personne;
		this.billeterie = billeterie;
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

	public Billetterie getBilleterie(){
		return billeterie;
	}

	public Personne getPersonne(){
		return personne;
	}
}
