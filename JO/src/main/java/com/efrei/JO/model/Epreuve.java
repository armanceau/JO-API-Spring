package com.efrei.JO.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Epreuve {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	@Column(
		length = 25
	)
	private String name;

	private LocalDate date;

	@ManyToOne
    @JoinColumn(name = "stade_uuid")
    private Stade stade;

	private LocalDateTime deletedAt = null;

	public Epreuve() {}
	public Epreuve(String name, LocalDate date, Stade stade) {
		this.name = name;
		this.date = date;
		this.stade = stade;
	}

	public String getUuid() {
		return uuid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void getDate(LocalDate date) {
		this.date = date;
	}

	public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
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
