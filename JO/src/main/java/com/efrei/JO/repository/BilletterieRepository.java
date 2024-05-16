package com.efrei.JO.repository;

import com.efrei.JO.model.Billetterie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BilletterieRepository extends JpaRepository<Billetterie, Integer> {

	// SELECT * from Billeterie where deleted_at is null
	List<Billetterie> findAllByDeletedAtNull();

	// SELECT * FROM Billeterie where uuid = ?
    Optional<Billetterie> findOneByUuid(String uuid);

	@SuppressWarnings({ "null", "unchecked" })
	Billetterie save(Billetterie billetterie);

	void deleteByUuid(String uuid);
}