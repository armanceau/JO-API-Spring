package com.efrei.JO.dto;

import jakarta.validation.constraints.*;

public class CreateBilletterie {

    @NotNull
    private String nom;

	public CreateBilletterie(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
}
