package kr.purred.playground.startboot.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableResourceServer
@Configuration
public class ResourceOAuthSecurityConfiguration extends ResourceServerConfigurerAdapter
{
	private ResourceServerProperties resourceServerProperties;

	public ResourceOAuthSecurityConfiguration (ResourceServerProperties resourceServerProperties)
	{
		this.resourceServerProperties = resourceServerProperties;
	}

	@Override
	public void configure (ResourceServerSecurityConfigurer resources) throws Exception
	{
		resources.resourceId (resourceServerProperties.getId ());
		resources.stateless (false);
		super.configure (resources);
	}

	@Override
	public void configure (HttpSecurity http) throws Exception
	{
		http
			.antMatcher ("/api/**")
			.authorizeRequests ()
			.antMatchers ("/api/**").authenticated ();
	}
}
