package com.efrei.JO.repository;

import com.efrei.JO.model.Epreuve;
import com.efrei.JO.model.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EpreuveRepository extends JpaRepository<Epreuve, String> {

	// SELECT * from Personne where deleted_at is null
	List<Epreuve> findAllByDeletedAtNull();

	// SELECT * FROM Student where uuid = ?
	Optional<Epreuve> findOneByUuid(String uuid);

	Epreuve save(Epreuve epreuve);

	void deleteByUuid(String uuid);
}
