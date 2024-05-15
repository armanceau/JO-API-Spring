package com.efrei.JO.service;

import com.efrei.JO.dto.CreateEpreuve;
import com.efrei.JO.dto.UpdateEpreuve;
import com.efrei.JO.model.Epreuve;
import com.efrei.JO.repository.EpreuveRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EpreuveService {

	private final EpreuveRepository repository;

	@Autowired
	public EpreuveService(EpreuveRepository repository) {
		this.repository = repository;
	}

	public List<Epreuve> findAllEpreuves() {
		return repository.findAllByDeletedAtNull();
	}

	public Epreuve findEpreuveById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Epreuve create(CreateEpreuve epreuve) {
		// ici je suis dans la DTO
		//
		Epreuve epreuveACreer = new Epreuve(
			epreuve.getName(),
			epreuve.getDate(),
			epreuve.getStade()
		);
		// je suis dans une entité
		return repository.save(epreuveACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Epreuve EpreuveASupprimer = findEpreuveById(uuid);
		if(EpreuveASupprimer != null && EpreuveASupprimer.getDeletedAt() == null) {
			EpreuveASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(EpreuveASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateEpreuve epreuve) {
		Epreuve epreuveAModifier = findEpreuveById(uuid);
		if(epreuveAModifier != null) {
			epreuveAModifier.setName(epreuve.getName());
			epreuveAModifier.setDate(epreuve.getDate());
			epreuveAModifier.setStade(epreuve.getStade());
			repository.save(epreuveAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateEpreuve epreuve) {
		Epreuve epreuveAModifier = findEpreuveById(uuid);
		if(epreuveAModifier != null) {
			if(epreuve.getName() != null) {
				epreuveAModifier.setName(epreuve.getName());
			}
			if(epreuve.getDate() != null) {
				epreuveAModifier.setDate(epreuve.getDate());
			}
			if(epreuve.getStade() != null) {
				epreuveAModifier.setStade(epreuve.getStade());
			}
			repository.save(epreuveAModifier);
			return true;
		}
		return false;
	}
}
