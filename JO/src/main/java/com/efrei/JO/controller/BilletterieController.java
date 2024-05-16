package com.efrei.JO.controller;

import com.efrei.JO.dto.CreateBilletterie;
import com.efrei.JO.model.Billetterie;
import com.efrei.JO.service.BilletterieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/billeteries")
@EnableMethodSecurity
public class BilletterieController {

	private final BilletterieService service;

	@Autowired
	public BilletterieController(BilletterieService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Billetterie>> findAll() {
		return new ResponseEntity<>(service.findAllBilletteries(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Billetterie> findOneById(@PathVariable String uuid) {
		Billetterie billetterie = service.findBilletterieById(uuid);
		if(billetterie != null) {
			return new ResponseEntity<>(service.findBilletterieById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	//@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public ResponseEntity<Billetterie> save(@Valid @RequestBody CreateBilletterie billetterie) {
		Billetterie createdBilletterie = service.create(billetterie);
		return new ResponseEntity<>(createdBilletterie, HttpStatus.CREATED);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<?> delete(@PathVariable String uuid) {
		boolean isDeleted = service.delete(uuid);
		if(isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

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
