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

	private final BilletterieRepository repos;

    @Autowired
    public BilletterieService(BilletterieRepository repos) {
        this.repos = repos;
    }

	public List<Billetterie> findAllBilletteries() {
		return repos.findAllByDeletedAtNull();
	}

    public Billetterie findBilletterieById(String uuid) {
        return repos.findOneByUuid(uuid).orElse(null);
    }

	public Billetterie create(CreateBilletterie billeterie) {
		// ici je suis dans la DTO
		//
		Billetterie billeterieACreer = new Billetterie(
			billeterie.getNom()
		);
		// je suis dans une entité
		return repos.save(billeterieACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Billetterie BilleterieASupprimer = findBilletterieById(uuid);
		if(BilleterieASupprimer != null && BilleterieASupprimer.getDeletedAt() == null) {
			BilleterieASupprimer.setDeletedAt(LocalDateTime.now());
			repos.save(BilleterieASupprimer);
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
