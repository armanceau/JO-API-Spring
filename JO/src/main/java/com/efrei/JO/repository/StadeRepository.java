package com.efrei.JO.repository;

import com.efrei.JO.model.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StadeRepository extends JpaRepository<Stade, String> {

	// SELECT * from Personne where deleted_at is null
	List<Stade> findAllByDeletedAtNull();

	// SELECT * FROM Student where uuid = ?
	Optional<Stade> findOneByUuid(String uuid);

	Stade save(Stade stade);

	void deleteByUuid(String uuid);
}
