package com.efrei.JO.dto;

import java.time.LocalDate;

import com.efrei.JO.model.Epreuve;
import jakarta.validation.constraints.*;


public class CreateBillet {

	private LocalDate dateValidite;

    @NotNull
    @Min(value = 0, message = "Le prix doit être supérieur à zéro")
    private Float prix;

    private Epreuve epreuve;

    private String billetterie;

	private boolean isValid;

	public CreateBillet(LocalDate dateValidite, Float prix, Epreuve epreuve, String billetterie) {
		this.dateValidite = dateValidite;
		this.prix = prix;
		this.epreuve = epreuve;
		this.billetterie = billetterie;
		this.isValid = dateValidite.isBefore(LocalDate.now());
	}

	public LocalDate getDateValidite() {
		return dateValidite;
	}

	public Float getPrix() {
		return prix;
	}

	public Epreuve getEpreuve() {
		return epreuve;
	}

	public String getBilletterie() {
		return billetterie;
	}

	public boolean isIsValid() {
		return this.isValid;
	}
}
