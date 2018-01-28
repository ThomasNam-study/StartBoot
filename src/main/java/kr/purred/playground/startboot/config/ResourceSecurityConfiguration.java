package kr.purred.playground.startboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ResourceSecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Override
	public void configure (WebSecurity web) throws Exception
	{
		super.configure (web);

		web.ignoring ().antMatchers ("/css/**");
	}

	@Override
	protected void configure (HttpSecurity http) throws Exception
	{
		http.authorizeRequests ()
			.antMatchers ("/", "/test/**").permitAll ()
			.anyRequest ().authenticated ()
		.and ()
			.formLogin ()
			.loginPage ("/login").permitAll ()
		.and ()
			.logout ().permitAll ();
	}
}
