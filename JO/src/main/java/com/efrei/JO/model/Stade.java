package com.efrei.JO.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Stade {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	@Column(
		length = 25
	)
	private String name;

	private String adresse;

	private String ville;

	private Integer capacite;

	private LocalDateTime deletedAt = null;

	public Stade() {}
	public Stade(String name, String adresse, String ville, Integer capacite) {
		this.name = name;
		this.adresse = adresse;
		this.ville = ville;
		this.capacite = capacite;
	}

	public String getUuid() {
		return uuid;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
}
