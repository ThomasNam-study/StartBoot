package kr.purred.playground.startboot.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProducerRedis
{
	private static final Logger log = LoggerFactory.getLogger (ProducerRedis.class);

	private final StringRedisTemplate template;

	public void sendTo (String topic, String message)
	{
		log.info ("전송> ...");

		this.template.convertAndSend (topic, message);
	}
}
