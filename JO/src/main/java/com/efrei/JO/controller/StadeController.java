package com.efrei.JO.controller;

import com.efrei.JO.dto.CreateStade;
import com.efrei.JO.dto.UpdateStade;
import com.efrei.JO.model.Stade;
import com.efrei.JO.service.StadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/stades")
@EnableMethodSecurity
public class StadeController {

	private final StadeService service;

	@Autowired
	public StadeController(StadeService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Stade>> findAll() {
		return new ResponseEntity<>(service.findAllStades(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Stade> findOneById(@PathVariable String uuid) {
		Stade stade = service.findStadeById(uuid);
		if(stade != null) {
			return new ResponseEntity<>(service.findStadeById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	//@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public ResponseEntity<Stade> save(@Valid @RequestBody CreateStade stade) {
		Stade createdStade = service.create(stade);
		return new ResponseEntity<>(createdStade, HttpStatus.CREATED);
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
			@RequestBody UpdateStade stade) {
		boolean isUpdated = service.update(uuid, stade);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@RequestBody UpdateStade stade) {
		boolean isUpdated = service.updatePartielle(uuid, stade);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
