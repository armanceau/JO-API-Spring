package com.efrei.JO.service;

import com.efrei.JO.dto.CreateStade;
import com.efrei.JO.dto.UpdateStade;
import com.efrei.JO.model.Stade;
import com.efrei.JO.repository.StadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StadeService {

	private final StadeRepository repository;

	@Autowired
	public StadeService(StadeRepository repository) {
		this.repository = repository;
	}

	public List<Stade> findAllStades() {
		return repository.findAllByDeletedAtNull();
	}

	public Stade findStadeById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Stade create(CreateStade stade) {
		// ici je suis dans la DTO
		//
		Stade stadeACreer = new Stade(
			stade.getName(),
			stade.getAdresse(),
			stade.getVille(),
			stade.getCapacite()
		);
		// je suis dans une entité
		return repository.save(stadeACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Stade stadeASupprimer = findStadeById(uuid);
		if(stadeASupprimer != null && stadeASupprimer.getDeletedAt() == null) {
			stadeASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(stadeASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateStade stade) {
		Stade stadeAModifier = findStadeById(uuid);

		if(stadeAModifier != null) {
			stadeAModifier.setName(stade.getName());
			stadeAModifier.setAdresse(stade.getAdresse());
			stadeAModifier.setVille(stade.getVille());
			stadeAModifier.setCapacite(stade.getCapacite());
			repository.save(stadeAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateStade stade) {
		Stade stadeAModifier = findStadeById(uuid);

		if(stadeAModifier != null) {
			if(stade.getName() != null) {
				stadeAModifier.setName(stade.getName());
			}
			if(stade.getAdresse() != null) {
				stadeAModifier.setAdresse(stade.getAdresse());
			}
			if(stade.getVille() != null) {
				stadeAModifier.setVille(stade.getVille());
			}
			if(stade.getCapacite() != null) {
				stadeAModifier.setCapacite(stade.getCapacite());
			}
			repository.save(stadeAModifier);
			return true;
		}
		return false;
	}
}
