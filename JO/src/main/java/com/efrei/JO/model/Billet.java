package com.efrei.JO.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Billet {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numero;

	private LocalDate dateValidite;

	private Float prix;

	@ManyToOne
    @JoinColumn(name = "epreuve_uuid")
    private Epreuve epreuve;

	@ManyToOne
	@JoinColumn(name = "personne_uuid")
    private Personne personne;

	private boolean isValid;

	private LocalDateTime deletedAt = null;

	public Billet() {}

	public Billet(String uuid, Integer numero, LocalDate dateValidite, Float prix, Epreuve epreuve, Personne personne, LocalDateTime deletedAt) {
		this.uuid = uuid;
		this.numero = numero;
		this.dateValidite = dateValidite;
		this.prix = prix;
		this.epreuve = epreuve;
		this.personne = personne;
		this.isValid = dateValidite.isBefore(LocalDate.now());
		this.deletedAt = deletedAt;
	}

	public String getUuid() {
		return uuid;
	}

	public Integer getNumero() {
		return numero;
	}

	public LocalDate getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(LocalDate dateValidite) {
		this.dateValidite = dateValidite;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Epreuve getEpreuve() {
		return epreuve;
	}

	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public boolean isIsValid() {
		return this.isValid;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

}
