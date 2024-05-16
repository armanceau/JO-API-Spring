package com.efrei.JO.dto;

import java.time.LocalDate;

import com.efrei.JO.model.*;

public class UpdateBillet {

	private Float prix;
	private LocalDate dateValidite;
    private Epreuve epreuve;
	private Personne personne;
	private Billetterie billetterie;


	public UpdateBillet(Float prix, LocalDate dateValidite, Epreuve epreuve, Personne personne, Billetterie billetterie) {
		this.prix = prix;
		this.dateValidite = dateValidite;
		this.epreuve = epreuve;
		this.personne = personne;
		this.billetterie = billetterie;
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

	public Billetterie getBilletterie(){
		return billetterie;
	}

	public Personne getPersonne(){
		return personne;
	}
}
