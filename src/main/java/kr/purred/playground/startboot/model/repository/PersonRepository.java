package kr.purred.playground.startboot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.purred.playground.startboot.model.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>
{
}
