package kr.purred.playground.startboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kr.purred.playground.startboot.model.domain.JournalEntry;

@RestController
public class JournalController
{
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
}
