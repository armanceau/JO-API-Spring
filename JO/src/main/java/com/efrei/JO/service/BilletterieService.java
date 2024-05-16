package com.efrei.JO.service;

import com.efrei.JO.dto.CreateBilletterie;
import com.efrei.JO.dto.UpdateBilletterie;
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

	public boolean update(String uuid, UpdateBilletterie billetterie) {
		Billetterie billetterieAModifier = findBilletterieById(uuid);
		if(billetterieAModifier != null) {
			billetterieAModifier.setName(billetterie.getName());
			repository.save(billetterieAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateBilletterie billetterie) {
		Billetterie billetterieAModifier = findBilletterieById(uuid);
		if(billetterieAModifier != null) {
			if(billetterie.getName() != null) {
				billetterieAModifier.setName(billetterie.getName());
			}
			repository.save(billetterieAModifier);
			return true;
		}
		return false;
	}
}
