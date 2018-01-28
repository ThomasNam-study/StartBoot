package kr.purred.playground.startboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kr.purred.playground.startboot.message.ProducerRedis;
import kr.purred.playground.startboot.model.domain.JournalEntry;
import kr.purred.playground.startboot.model.repository.JournalRepository;

@RestController
public class JournalController
{
	@Autowired JournalRepository journalRepository;

	@Autowired ProducerRedis producerRedis;

	/**
	 * 카운터 Sv
	 */
	@Autowired CounterService counterService;

	private static List<JournalEntry> entries = new ArrayList<> ();

	static
	{
		try
		{
			entries.add (new JournalEntry ("스프링 부트 입문", "드디어 스프링 부트 입문이다.", "01/01/2016"));
			entries.add (new JournalEntry ("스프링 부트 입문2", "드디어 스프링 부트 입문이다.", "01/01/2016"));
			entries.add (new JournalEntry ("스프링 부트 입문3", "드디어 스프링 부트 입문이다.", "01/01/2016"));
			entries.add (new JournalEntry ("스프링 부트 입문4", "드디어 스프링 부트 입문이다.", "01/01/2016"));
			entries.add (new JournalEntry ("스프링 부트 입문5", "드디어 스프링 부트 입문이다.", "01/01/2016"));
			entries.add (new JournalEntry ("스프링 부트 입문6", "드디어 스프링 부트 입문이다.", "01/01/2016"));
		}
		catch (ParseException e)
		{
			e.printStackTrace ();
		}
	}

	@GetMapping("/journal/all")
	public List<JournalEntry> getAll()
	{
		return entries;
	}

	@GetMapping("/journal/findBy/title/{title}")
	public List<JournalEntry> findByTitleContains(@PathVariable("title") String title)
	{
		return entries.stream ().filter ((e) -> e.getTitle ().toLowerCase ().contains (title)).collect(Collectors.toList ());
	}

	@PostMapping("/journal")
	public JournalEntry add (@RequestBody JournalEntry entry)
	{
		entries.add (entry);

		return entry;
	}

	@GetMapping("/")
	public ModelAndView index (ModelAndView mv)
	{
		counterService.increment ("INDEX");

		mv.setViewName ("index");

		mv.addObject ("journal", journalRepository.findAll ());

		producerRedis.sendTo ("spring-boot", "스프링 부트와 레디스 메시징 시작!");

		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login (ModelAndView mv)
	{
		mv.setViewName ("login");

		return mv;
	}
}
