package kr.purred.playground.startboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

// 인메모리 비활성화
@Configuration
@EnableGlobalAuthentication
@Profile ("memory")
public class InMemorySecurityConfiguration
{
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication ().withUser ("user").password ("password").roles ("USER")
			.and ().withUser ("admin").password ("password").roles ("USER", "ADMIN");
	}
}
