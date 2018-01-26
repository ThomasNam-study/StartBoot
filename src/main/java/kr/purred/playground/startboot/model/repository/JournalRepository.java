package kr.purred.playground.startboot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

import kr.purred.playground.startboot.model.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long>
{
	List<Journal> findByTitleContaining (String word);

	List<Journal> findByCreatedAfter (Date date);

	@Query("SELECT j from Journal j where j.title like %?1%")
	List<Journal> findByCustomQuery (String word);
}
