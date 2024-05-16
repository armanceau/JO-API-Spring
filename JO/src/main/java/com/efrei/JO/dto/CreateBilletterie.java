package com.efrei.JO.dto;

import jakarta.validation.constraints.*;

public class CreateBilletterie {

	@NotBlank
	@Size(min = 1, max = 40)
	private String name;

	public CreateBilletterie(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
