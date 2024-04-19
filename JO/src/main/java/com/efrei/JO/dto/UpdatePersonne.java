package com.efrei.JO.dto;

public class UpdatePersonne {


	private String name;

	private String firstname;

	private Float solde;

	public UpdatePersonne(String name, String firstname, Float solde) {
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

	public Float getSolde(){
		return solde;
	}
}
