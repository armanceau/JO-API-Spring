package com.efrei.JO.dto;

import java.time.LocalDate;

import com.efrei.JO.model.Stade;

import jakarta.validation.constraints.*;


public class CreateEpreuve {

	@NotBlank
	@Size(min = 1, max = 40)
	private String name;

	@NotNull
	private LocalDate date;

	@NotNull
	private Stade stade;

	public CreateEpreuve(String name, LocalDate date, Stade stade) {
		this.name = name;
		this.date = date;
		this.stade = stade;
	}

	public LocalDate getDate() {
		return date;
	}

	public Stade getStade() {
		return stade;
	}

	public String getName() {
		return name;
	}
}
