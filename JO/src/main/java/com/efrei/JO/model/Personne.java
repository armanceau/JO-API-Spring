package com.efrei.JO.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	@Column(
		length = 25
	)
	private String name;

	private String firstname;

	private LocalDateTime deletedAt = null;

	private Float solde;

	public Personne() {}
	public Personne(String name, String firstname, Float solde) {
		this.name = name;
		this.firstname = firstname;
		this.solde = solde;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Float getSolde() {
		return solde;
	}

	public void setSolde(Float solde) {
		this.solde = solde;
	}


	public String getUuid() {
		return uuid;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
}
