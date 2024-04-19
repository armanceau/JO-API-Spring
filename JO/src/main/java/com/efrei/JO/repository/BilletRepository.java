package com.efrei.JO.repository;

import com.efrei.JO.model.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BilletRepository extends JpaRepository<Billet, String> {

	// SELECT * from Billet where deleted_at is null
	List<Billet> findAllByDeletedAtNull();

	// SELECT * FROM Billet where uuid = ?
	Optional<Billet> findOneByUuid(String uuid);

	Billet save(Billet billet);

	void deleteByUuid(String uuid);
}
