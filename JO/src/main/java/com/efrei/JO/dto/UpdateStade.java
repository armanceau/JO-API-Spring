package com.efrei.JO.dto;

public class UpdateStade {

	private String name;
	private String adresse;
	private String ville;
	private Integer capacite;

	public UpdateStade(String name, String adresse, String ville, Integer capacite) {
		this.name = name;
		this.adresse = adresse;
		this.ville = ville;
		this.capacite = capacite;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public String getVille() {
		return this.ville;
	}

	public Integer getCapacite() {
		return this.capacite;
	}

	public String getName() {
		return name;
	}
}
