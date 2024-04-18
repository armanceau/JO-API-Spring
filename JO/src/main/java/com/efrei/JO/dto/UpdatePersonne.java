package com.efrei.JO.dto;

public class UpdatePersonne {


	private String name;

	private String firstname;

	public UpdatePersonne(String name, String firstname) {
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
