package kr.purred.playground.startboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.purred.playground.startboot.model.JournalJdbcService;

@RunWith (SpringRunner.class)
@SpringBootTest
public class JournalJdbcTest
{
	@Autowired JournalJdbcService journalService;

	@Test
	public void findAllTest ()
	{
		journalService.insertData ();

		System.out.println (journalService.findAll ());
	}
}
