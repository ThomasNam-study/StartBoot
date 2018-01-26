package kr.purred.playground.startboot.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.purred.playground.startboot.model.domain.JournalSimple;

@Service
public class JournalJdbcService
{
	private static final Logger log = LoggerFactory.getLogger (JournalJdbcService.class);

	@Autowired JdbcTemplate jdbcTemplate;

	public void insertData ()
	{
		log.info (">테이블 생성");

		jdbcTemplate.execute ("DROP TABLE JOURNAL IF EXISTS");
		jdbcTemplate.execute ("CREATE TABLE JOURNAL (id SERIAL, title VARCHAR(255), summary VARCHAR(255), created TIMESTAMP)");

		log.info ("> 데이터 생성");

		jdbcTemplate.execute ("INSERT INTO JOURNAL(title, summary, created) VALUES ('스프링 부트 입문', '오늘 부터 스프링 배웠다.', '2018-01-26 00:00:00.00')");
		jdbcTemplate.execute ("INSERT INTO JOURNAL(title, summary, created) VALUES ('스프링 부트 입문', '오늘 부터 스프링 배웠다.', '2018-01-26 00:00:00.00')");
		jdbcTemplate.execute ("INSERT INTO JOURNAL(title, summary, created) VALUES ('스프링 부트 입문', '오늘 부터 스프링 배웠다.', '2018-01-26 00:00:00.00')");
		jdbcTemplate.execute ("INSERT INTO JOURNAL(title, summary, created) VALUES ('스프링 부트 입문', '오늘 부터 스프링 배웠다.', '2018-01-26 00:00:00.00')");
		jdbcTemplate.execute ("INSERT INTO JOURNAL(title, summary, created) VALUES ('스프링 부트 입문', '오늘 부터 스프링 배웠다.', '2018-01-26 00:00:00.00')");

		log.info ("> 완료");
	}

	public List<JournalSimple> findAll ()
	{
		List<JournalSimple> journals = new ArrayList<> ();

		journals.addAll (jdbcTemplate.query ("SELECT * FROM JOURNAL", new Object[] {}, (rs, row) -> new JournalSimple (rs.getLong ("id"), rs.getString ("title"), rs.getString ("summary"),
			new Date (rs.getTimestamp ("created").getTime ()))));

		return journals;
	}
}
