package kr.purred.playground.startboot.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class JournalEntry
{
	private String title;

	private Date created;

	private String summary;

	@JsonIgnore
	private final SimpleDateFormat format = new SimpleDateFormat ("MM/dd/yyyy");

	public JournalEntry ()
	{
	}

	public JournalEntry (String title, String summary, String date) throws ParseException
	{
		this.title = title;
		this.summary = summary;

		this.created = format.parse (date);
	}

	public void setCreated (String date) throws ParseException
	{
		Long _date = null;

		try
		{
			_date = Long.parseLong (date);

			this.created = new Date (_date);

			return;
		}
		catch (Exception e) {}

		this.created = format.parse (date);
	}
}
