package com.efrei.JO.controller;

import com.efrei.JO.dto.CreatePersonne;
import com.efrei.JO.dto.UpdatePersonne;
import com.efrei.JO.model.Personne;
import com.efrei.JO.service.PersonneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/personnes")
@EnableMethodSecurity
public class PersonneController {

	private final PersonneService service;

	@Autowired
	public PersonneController(PersonneService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Personne>> findAll() {
		return new ResponseEntity<>(service.findAllPersonnes(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Personne> findOneById(@PathVariable String uuid) {
		Personne personne = service.findPersonneById(uuid);
		if(personne != null) {
			return new ResponseEntity<>(service.findPersonneById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public ResponseEntity<Personne> save(@Valid @RequestBody CreatePersonne personne) {
		Personne createdPersonne = service.create(personne);
		return new ResponseEntity<>(createdPersonne, HttpStatus.CREATED);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<?> delete(@PathVariable String uuid) {
		boolean isDeleted = service.delete(uuid);
		if(isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<?> mettreAJourTotalement(
			@PathVariable String uuid,
			@RequestBody UpdatePersonne personne) {
		boolean isUpdated = service.update(uuid, personne);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@RequestBody UpdatePersonne personne) {
		boolean isUpdated = service.updatePartielle(uuid, personne);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
