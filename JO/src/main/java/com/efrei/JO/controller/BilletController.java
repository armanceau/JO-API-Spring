package com.efrei.JO.controller;

import com.efrei.JO.dto.CreateBillet;
import com.efrei.JO.model.Billet;
import com.efrei.JO.service.BilletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/billets")
@EnableMethodSecurity
public class BilletController {

	private final BilletService service;

	@Autowired
	public BilletController(BilletService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Billet>> findAll() {
		return new ResponseEntity<>(service.findAllBillets(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Billet> findOneById(@PathVariable String uuid) {
		Billet billet = service.findBilletById(uuid);
		if(billet != null) {
			return new ResponseEntity<>(service.findBilletById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	//@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public ResponseEntity<Billet> save(@Valid @RequestBody CreateBillet billet) {
		Billet createdBillet = service.create(billet);
		return new ResponseEntity<>(createdBillet, HttpStatus.CREATED);
	}

	// @DeleteMapping("/{uuid}")
	// public ResponseEntity<?> delete(@PathVariable String uuid) {
	// 	boolean isDeleted = service.delete(uuid);
	// 	if(isDeleted) {
	// 		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// 	}
	// 	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }

	// @PutMapping("/{uuid}")
	// public ResponseEntity<?> mettreAJourTotalement(
	// 		@PathVariable String uuid,
	// 		@RequestBody UpdateStade stade) {
	// 	boolean isUpdated = service.update(uuid, stade);
	// 	if(isUpdated) {
	// 		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// 	}
	// 	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }

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
