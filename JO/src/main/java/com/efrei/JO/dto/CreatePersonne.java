package com.efrei.JO.dto;

import jakarta.validation.constraints.*;


public class CreatePersonne {

	@NotBlank
	@Size(min = 1, max = 25)
	private String name;

	@NotBlank
	private String firstname;

	@NotNull
	private float solde;

	public CreatePersonne(String name, String firstname, Float solde) {
		this.name = name;
		this.firstname = firstname;
		this.solde = solde;
	}

	public String getName() {
		return name;
	}

	public String getFirstname() {
		return firstname;
	}

	public Float getSolde() {
		return solde;
	}
}
