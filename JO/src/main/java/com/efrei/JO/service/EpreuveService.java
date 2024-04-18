package com.efrei.JO.service;

import com.efrei.JO.dto.CreateEpreuve;
import com.efrei.JO.dto.UpdateStade;
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

	// public boolean update(String uuid, UpdateStade stade) {
	// 	Stade stadeAModifier = findStadeById(uuid);
	// 	if(stadeAModifier != null) {
	// 		stadeAModifier.setName(stade.getName());
	// 		stadeAModifier.setAdresse(stade.getAdresse());
	// 		stadeAModifier.setVille(stade.getVille());
	// 		stadeAModifier.setCapacite(stade.getCapacite());
	// 		repository.save(stadeAModifier);
	// 		return true;
	// 	}
	// 	return false;
	// }

	// public boolean updatePartielle(String uuid, UpdateStade stade) {
	// 	Stade stadeAModifier = findStadeById(uuid);
	// 	if(stadeAModifier != null) {
	// 		if(stade.getName() != null) {
	// 			stadeAModifier.setName(stade.getName());
	// 		}
	// 		if(stade.getAdresse() != null) {
	// 			stadeAModifier.setAdresse(stade.getAdresse());
	// 		}
	// 		if(stade.getVille() != null) {
	// 			stadeAModifier.setVille(stade.getVille());
	// 		}
	// 		if(stade.getCapacite() != null) {
	// 			stadeAModifier.setCapacite(stade.getCapacite());
	// 		}
	// 		repository.save(stadeAModifier);
	// 		return true;
	// 	}
	// 	return false;
	// }
}
