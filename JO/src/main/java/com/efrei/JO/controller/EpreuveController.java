package com.efrei.JO.controller;

import com.efrei.JO.dto.CreateEpreuve;
import com.efrei.JO.dto.UpdateEpreuve;
import com.efrei.JO.model.Epreuve;
import com.efrei.JO.service.EpreuveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/epreuves")
@EnableMethodSecurity
public class EpreuveController {

	private final EpreuveService service;

	@Autowired
	public EpreuveController(EpreuveService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Epreuve>> findAll() {
		return new ResponseEntity<>(service.findAllEpreuves(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Epreuve> findOneById(@PathVariable String uuid) {
		Epreuve epreuve = service.findEpreuveById(uuid);
		if(epreuve != null) {
			return new ResponseEntity<>(service.findEpreuveById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	//@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public ResponseEntity<Epreuve> save(@Valid @RequestBody CreateEpreuve epreuve) {
		Epreuve createdEpreuve = service.create(epreuve);
		return new ResponseEntity<>(createdEpreuve, HttpStatus.CREATED);
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
			@RequestBody UpdateEpreuve epreuve) {
		boolean isUpdated = service.update(uuid, epreuve);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// @PatchMapping("/{uuid}")
	// public ResponseEntity<?> mettreAjourPartiellement(
	// 		@PathVariable String uuid,
	// 		@RequestBody UpdateStade stade) {
	// 	boolean isUpdated = service.updatePartielle(uuid, stade);
	// 	if(isUpdated) {
	// 		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// 	}
	// 	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
}
