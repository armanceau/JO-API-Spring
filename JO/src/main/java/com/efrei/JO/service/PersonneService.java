package com.efrei.JO.service;

import com.efrei.JO.dto.CreatePersonne;
import com.efrei.JO.dto.UpdatePersonne;
import com.efrei.JO.model.Personne;
import com.efrei.JO.repository.PersonneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonneService {

	private final PersonneRepository repository;

	@Autowired
	public PersonneService(PersonneRepository repository) {
		this.repository = repository;
	}

	public List<Personne> findAllPersonnes() {
		return repository.findAllByDeletedAtNull();
	}

	public Personne findPersonneById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Personne create(CreatePersonne personne) {
		// ici je suis dans la DTO
		//
		Personne personneACreer = new Personne(
			personne.getName(),
			personne.getFirstname()
		);
		// je suis dans une entité
		return repository.save(personneACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Personne personneASupprimer = findPersonneById(uuid);
		if(personneASupprimer != null && personneASupprimer.getDeletedAt() == null) {
			personneASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(personneASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdatePersonne personne) {
		Personne personneAModifier = findPersonneById(uuid);

		if(personneAModifier != null) {
			personneAModifier.setFirstname(personne.getFirstname());
			personneAModifier.setName(personne.getName());
			repository.save(personneAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdatePersonne personne) {
		Personne personneAModifier = findPersonneById(uuid);

		if(personneAModifier != null) {
			if(!personne.getFirstname().isEmpty()) {
				personneAModifier.setFirstname(personne.getFirstname());
			}
			if(!personne.getName().isEmpty()) {
				personneAModifier.setName(personne.getName());
			}
			repository.save(personneAModifier);
			return true;
		}
		return false;
	}
}
