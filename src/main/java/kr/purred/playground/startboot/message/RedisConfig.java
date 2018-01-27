package kr.purred.playground.startboot.message;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig
{
	private final String topic = "spring-boot";

	@Bean RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter)
	{
		RedisMessageListenerContainer container = new RedisMessageListenerContainer ();

		container.setConnectionFactory (connectionFactory);

		container.addMessageListener (listenerAdapter, new PatternTopic (topic));

		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter (ConsumerRedis consumerRedis)
	{
		return new MessageListenerAdapter (consumerRedis, "messageHandler");
	}
}
