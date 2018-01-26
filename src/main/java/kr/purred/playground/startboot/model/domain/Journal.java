package kr.purred.playground.startboot.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
public class Journal
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	private Date created;

	private String summary;

	@Transient
	@JsonIgnore
	private final SimpleDateFormat format = new SimpleDateFormat ("MM/dd/yyyy");

	public Journal ()
	{
	}

	public Journal (String title, String summary, Date created)
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
