package kr.purred.playground.startboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class StartbootApplication extends SpringBootServletInitializer
{

	public static void main (String[] args)
	{
		new SpringApplicationBuilder (StartbootApplication.class)
			.run (args);
	}

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder)
	{
		return builder.sources (SpringBootApplication.class);
	}
}
