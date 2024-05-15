package com.efrei.JO.dto;

import java.time.LocalDate;
import com.efrei.JO.model.Stade;

public class UpdateEpreuve {

	private String name;
	private LocalDate date;
    private Stade stade;

	public UpdateEpreuve(String name, LocalDate date, Stade stade) {
		this.name = name;
		this.date = date;
		this.stade = stade;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDate() {
		return date;
	}

	public Stade getStade(){
		return stade;
	}
}
