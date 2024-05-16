package com.efrei.JO.service;

import com.efrei.JO.dto.CreateBillet;
import com.efrei.JO.dto.UpdateBillet;
import com.efrei.JO.model.Billet;
import com.efrei.JO.model.Billetterie;
import com.efrei.JO.model.Personne;
import com.efrei.JO.repository.BilletRepository;
//import com.efrei.JO.repository.BilletterieRepository;
import com.efrei.JO.repository.PersonneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BilletService {

	private final BilletRepository billetRepository;
    private final PersonneRepository personneRepository;
	private final BilletterieService billetterieService;
	//private final BilletterieRepository billetterieRepository;


    @Autowired
    public BilletService(BilletRepository billetRepository, PersonneRepository personneRepository, BilletterieService billetterieService) {
        this.billetRepository = billetRepository;
        this.personneRepository = personneRepository;
		this.billetterieService = billetterieService;
    }

	public List<Billet> findAllBillets() {
		return billetRepository.findAllByDeletedAtNull();
	}

    public Billet findBilletById(String uuid) {
        return billetRepository.findOneByUuid(uuid).orElse(null);
    }

    public Billet create(CreateBillet billetData) {
        // Créer le billet
		Billetterie billetterie  = billetterieService.findBilletterieById(billetData.getBilletterie());
        Billet billet = new Billet(billetData.getDateValidite(), billetData.getPrix(), billetData.getEpreuve());
		billet.setBilletterie(billetterie);
		//billeterie.getBillets().add(billet);
        return billetRepository.save(billet);
    }

	@Transactional
	public boolean delete(String uuid) {
		Billet billetASupprimer = findBilletById(uuid);
		if(billetASupprimer != null && billetASupprimer.getDeletedAt() == null) {
			billetASupprimer.setDeletedAt(LocalDateTime.now());
			billetRepository.save(billetASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateBillet billet) {
		Billet billetAModifier = findBilletById(uuid);

		if(billetAModifier != null) {
			// Récupérer la personne à partir de son UUID
			Personne personne = personneRepository.findOneByUuid(billet.getPersonne().getUuid())
					.orElseThrow(() -> new IllegalArgumentException("La personne spécifiée n'existe pas"));

			// Vérifier si le solde de la personne est suffisant
			Float soldeRestant = personne.getSolde() - billet.getPrix();
			if (soldeRestant < 0) {
				throw new IllegalArgumentException("Le solde de la personne est insuffisant pour acheter ce billet");
			}

			// Déduire le prix du billet du solde de la personne
			personne.setSolde(soldeRestant);
			personneRepository.save(personne);

			billetAModifier.setDateValidite(billet.getDateValidite());
			billetAModifier.setPrix(billet.getPrix());
			billetAModifier.setEpreuve(billet.getEpreuve());
			billetAModifier.setPersonne(personne);
			billetAModifier.setBilletterie(billet.getBilletterie());
			billetRepository.save(billetAModifier);
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
			if(billet.getBilletterie() != null) {
				billetAModifier.setBilletterie(billet.getBilletterie());
			}
			billetRepository.save(billetAModifier);
			return true;
		}
		return false;
	}
}