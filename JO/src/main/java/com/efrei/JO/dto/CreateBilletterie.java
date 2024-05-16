package com.efrei.JO.dto;

import java.util.HashSet;
import java.util.Set;

import com.efrei.JO.model.Billet;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class CreateBilletterie {

	@NotBlank
	@Size(min = 1, max = 40)
	private String name;

	@Column(nullable = true)
	private Set<Billet> billets = new HashSet<>();

	public CreateBilletterie(String name, Set<Billet> billets) {
		this.name = name;
		this.billets = billets;
	}

	public Set<Billet> getBillets() {
		return billets;
	}

	public String getName() {
		return name;
	}
}
