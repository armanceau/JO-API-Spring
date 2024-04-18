package com.efrei.JO.dto;

import jakarta.validation.constraints.*;


public class CreatePersonne {

	@NotBlank
	@Size(min = 1, max = 25)
	private String name;

	@NotBlank
	private String firstname;

	public CreatePersonne(String name, String firstname) {
		this.name = name;
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public String getFirstname() {
		return firstname;
	}
}
