package com.efrei.JO.dto;

import jakarta.validation.constraints.*;


public class CreateStade {

	@NotBlank
	@Size(min = 1, max = 40)
	private String name;

	@NotBlank
	private String adresse;

	@NotBlank
	private String ville;

	@NotNull
	private Integer capacite;

	public CreateStade(String name, String adresse, String ville, Integer capacite) {
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
