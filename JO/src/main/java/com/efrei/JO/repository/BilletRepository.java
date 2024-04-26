package com.efrei.JO.repository;

import com.efrei.JO.model.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BilletRepository extends JpaRepository<Billet, Integer> {

	// SELECT * from Billet where deleted_at is null
	List<Billet> findAllByDeletedAtNull();

	// SELECT * FROM Billet where uuid = ?
	Optional<Billet> findOneByNumero(Integer numero);

	Billet save(Billet billet);

	void deleteByNumero(Integer numero);
}