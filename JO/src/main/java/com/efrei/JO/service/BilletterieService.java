package com.efrei.JO.service;

import com.efrei.JO.dto.CreateBilletterie;
//import com.efrei.JO.dto.UpdateBilletterie;
import com.efrei.JO.model.Billetterie;
import com.efrei.JO.repository.BilletterieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BilletterieService {

	private final BilletterieRepository repository;

    @Autowired
    public BilletterieService(BilletterieRepository repository) {
        this.repository = repository;
    }

	public List<Billetterie> findAllBilletteries() {
		return repository.findAllByDeletedAtNull();
	}

    public Billetterie findBilletterieById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

	public Billetterie create(CreateBilletterie billetterie) {
		// ici je suis dans la DTO
		//
		Billetterie billetterieACreer = new Billetterie(
			billetterie.getName()
		);
		// je suis dans une entité
		return repository.save(billetterieACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Billetterie BilletterieASupprimer = findBilletterieById(uuid);
		if(BilletterieASupprimer != null && BilletterieASupprimer.getDeletedAt() == null) {
			BilletterieASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(BilletterieASupprimer);
			return true;
		}
		return false;
	}

	// public boolean update(String uuid, UpdateEpreuve epreuve) {
	// 	Epreuve epreuveAModifier = findEpreuveById(uuid);
	// 	if(epreuveAModifier != null) {
	// 		epreuveAModifier.setName(epreuve.getName());
	// 		epreuveAModifier.setDate(epreuve.getDate());
	// 		epreuveAModifier.setStade(epreuve.getStade());
	// 		repository.save(epreuveAModifier);
	// 		return true;
	// 	}
	// 	return false;
	// }

	// public boolean updatePartielle(String uuid, UpdateEpreuve epreuve) {
	// 	Epreuve epreuveAModifier = findEpreuveById(uuid);
	// 	if(epreuveAModifier != null) {
	// 		if(epreuve.getName() != null) {
	// 			epreuveAModifier.setName(epreuve.getName());
	// 		}
	// 		if(epreuve.getDate() != null) {
	// 			epreuveAModifier.setDate(epreuve.getDate());
	// 		}
	// 		if(epreuve.getStade() != null) {
	// 			epreuveAModifier.setStade(epreuve.getStade());
	// 		}
	// 		repository.save(epreuveAModifier);
	// 		return true;
	// 	}
	// 	return false;
	// }
}
