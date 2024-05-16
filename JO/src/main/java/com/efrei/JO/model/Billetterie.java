package com.efrei.JO.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Billetterie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

	private String nom;

	@ManyToMany
	private Set<Billet> billets = new HashSet<>();

	private LocalDateTime deletedAt = null;

	public Billetterie() {}

	public Billetterie(String nom) {
		this.nom = nom;
	}

	public String GetUuid() {
		return uuid;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
}