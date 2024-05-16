package com.efrei.JO.dto;

import java.time.LocalDate;

import com.efrei.JO.model.Billetterie;
import com.efrei.JO.model.Epreuve;
import com.efrei.JO.model.Personne;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;


public class CreateBillet {

	private LocalDate dateValidite;

    @NotNull
    @Min(value = 0, message = "Le prix doit être supérieur à zéro")
    private Float prix;

	@ManyToOne
    @JoinColumn(name = "epreuve_uuid")
    private Epreuve epreuve;

	@ManyToOne
	@JoinColumn(name = "personne_uuid")
    private Personne personne;

	@ManyToOne
	@JoinColumn(name = "billeterie_uuid")
    private Billetterie billeterie;

	private boolean isValid;

	public CreateBillet(LocalDate dateValidite, Float prix, Epreuve epreuve, Personne personne, Billetterie billeterie) {
		this.dateValidite = dateValidite;
		this.prix = prix;
		this.epreuve = epreuve;
		this.personne = personne;
		this.billeterie = billeterie;
		this.isValid = dateValidite.isBefore(LocalDate.now());
	}

	public LocalDate getDateValidite() {
		return dateValidite;
	}

	public Float getPrix() {
		return prix;
	}

	public Epreuve getEpreuve() {
		return epreuve;
	}

	public Billetterie getBilleterie() {
		return billeterie;
	}

	public Personne getPersonne() {
		return personne;
	}

	public boolean isIsValid() {
		return this.isValid;
	}
}
