package com.efrei.JO.service;

import com.efrei.JO.dto.CreateStade;
import com.efrei.JO.dto.UpdateStade;
import com.efrei.JO.model.Billet;
import com.efrei.JO.model.Stade;
import com.efrei.JO.repository.BilletRepository;
import com.efrei.JO.repository.StadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BilletService {

	private final BilletRepository repository;

	@Autowired
	public BilletService(BilletRepository repository) {
		this.repository = repository;
	}

	public List<Billet> findAllBillets() {
		return repository.findAllByDeletedAtNull();
	}

	public Billet findBilletById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Billet create(CreateBillet billet) {
		// ici je suis dans la DTO
		//
		Billet billetACreer = new Billet(
			billet.getDateValidite(),
			billet.getPrix(),
			billet.getEpreuve(),
			billet.getPersonne()
		);
		// je suis dans une entité
		return repository.save(billetACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Billet billetASupprimer = findBilletById(uuid);
		if(billetASupprimer != null && billetASupprimer.getDeletedAt() == null) {
			billetASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(billetASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateBillet billet) {
		Billet billetAModifier = findBilletById(uuid);

		if(billetAModifier != null) {
			billetAModifier.setDateValidite(billet.getDateValidite());
			billetAModifier.setPrix(billet.getPrix());
			billetAModifier.setEpreuve(billet.getEpreuve());
			billetAModifier.setPersonne(billet.getPersonne());
			repository.save(billetAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateBillet billet) {
		Billet billetAModifier = findBilletById(uuid);

		if(billetAModifier != null) {
			if(billet.getDateValidite() != null) {
				billetAModifier.setDateValidite(billet.getDateValidite());
			}
			if(billet.getPrix() != null) {
				billetAModifier.setPrix(billet.getPrix());
			}
			if(billet.getEpreuve() != null) {
				billetAModifier.setEpreuve(billet.getEpreuve());
			}
			if(billet.getPersonne() != null) {
				billetAModifier.setPersonne(billet.getPersonne());
			}
			repository.save(billetAModifier);
			return true;
		}
		return false;
	}
}
