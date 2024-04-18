package com.efrei.JO.repository;

import com.efrei.JO.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, String> {

	// SELECT * from Personne where deleted_at is null
	List<Personne> findAllByDeletedAtNull();

	// SELECT * FROM Personne where uuid = ?
	Optional<Personne> findOneByUuid(String uuid);

	Personne save(Personne personne);

	void deleteByUuid(String uuid);
}
