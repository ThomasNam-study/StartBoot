package kr.purred.playground.startboot.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class JournalSimple
{
	private Long id;

	private String title;

	private Date created;

	private String summary;

	@JsonIgnore
	private final SimpleDateFormat format = new SimpleDateFormat ("MM/dd/yyyy");

	public JournalSimple ()
	{
	}

	public JournalSimple (Long id, String title, String summary, Date created)
	{
		this.id = id;
		this.title = title;
		this.created = created;
		this.summary = summary;
	}

	public String getCreatedAsShort ()
	{
		return format.format (this.created);
	}
}
