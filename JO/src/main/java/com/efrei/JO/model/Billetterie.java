package com.efrei.JO.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Billetterie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

	@Column(
		nullable = false,
		length = 100
	)
	private String name;

	private LocalDateTime deletedAt = null;

	public Billetterie() {}

	public Billetterie(String name) {
		this.name = name;
	}

	public String GetUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
}