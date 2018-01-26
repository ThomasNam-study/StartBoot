package kr.purred.playground.startboot.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import kr.purred.playground.startboot.model.domain.Journal;
import kr.purred.playground.startboot.model.repository.JournalRepository;

@Service
public class JournalService
{
	private static final Logger log = LoggerFactory.getLogger (JournalService.class);

	@Autowired JournalRepository journalRepository;

	public void insertData ()
	{
		log.info (">테이블 생성");

		journalRepository.save (new Journal ("스프링 부트 입문", "오늘부터 스프링 부트를 배운다.", new Date ()));
		journalRepository.save (new Journal ("스프링 부트 입문", "오늘부터 스프링 부트를 배운다.", new Date ()));
		journalRepository.save (new Journal ("스프링 부트 입문", "오늘부터 스프링 부트를 배운다.", new Date ()));
		journalRepository.save (new Journal ("스프링 부트 입문", "오늘부터 스프링 부트를 배운다.", new Date ()));
		journalRepository.save (new Journal ("스프링 부트 입문", "오늘부터 스프링 부트를 배운다.", new Date ()));
	}

	public List<Journal> findAll ()
	{
		return journalRepository.findAll ();
	}
}
