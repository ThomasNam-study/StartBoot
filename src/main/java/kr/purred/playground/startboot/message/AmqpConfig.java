package kr.purred.playground.startboot.message;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig
{
	@Bean
	public Queue queue()
	{
		return new Queue ("spring-boot", false);
	}
}
