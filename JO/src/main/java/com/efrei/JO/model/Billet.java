package com.efrei.JO.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "numero", unique = true, nullable = false)
    private String uuid;

	private LocalDate dateValidite;

	private Float prix;

	@ManyToOne
    @JoinColumn(name = "epreuve_uuid")
    private Epreuve epreuve;

	@ManyToOne (optional = true)
	@JoinColumn(name = "personne_uuid", nullable = true)
    private Personne personne;

	@ManyToOne
	@JoinColumn(name = "billetterie_uuid")
    private Billetterie billetterie;

	private boolean isValid;

	private LocalDateTime deletedAt = null;

	public Billet() {}

	public Billet(LocalDate dateValidite, Float prix, Epreuve epreuve) {
		this.dateValidite = dateValidite;
		this.prix = prix;
		this.epreuve = epreuve;
		this.isValid = dateValidite.isBefore(LocalDate.now());
	}

	//Constructeur de la création d'un billet (billet n'appartient pour l'instant à personne)
	public Billet(LocalDate dateValidite, Float prix, Epreuve epreuve, Billetterie billetterie) {
		this.dateValidite = dateValidite;
		this.prix = prix;
		this.epreuve = epreuve;
		this.isValid = dateValidite.isBefore(LocalDate.now());
		this.billetterie = billetterie;
	}

	//Constructeur de l'update d'un billet (attrivution du billet à une personne)
	public Billet(LocalDate dateValidite, Float prix, Epreuve epreuve, Personne personne, Billetterie billetterie) {
		this.dateValidite = dateValidite;
		this.prix = prix;
		this.epreuve = epreuve;
		this.personne = personne;
		this.isValid = dateValidite.isBefore(LocalDate.now());
	}

	public String GetUuid() {
		return uuid;
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

	public Billetterie getBilletterie() {
		return billetterie;
	}

	public void setBilletterie(Billetterie billetterie) {
		this.billetterie = billetterie;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

}