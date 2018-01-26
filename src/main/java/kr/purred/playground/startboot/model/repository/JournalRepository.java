package kr.purred.playground.startboot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import kr.purred.playground.startboot.model.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long>
{
	List<Journal> findByTitleContaining (@Param("word") String word);

	List<Journal> findBySummaryContaining (@Param("word") String word);

	List<Journal> findByTitleBetween (@Param ("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date after, @Param ("before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date before);

	List<Journal> findByCreatedAfter (@Param ("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date);

	@Query("SELECT j from Journal j where j.title like %?1%")
	List<Journal> findByCustomQuery (String word);


}
