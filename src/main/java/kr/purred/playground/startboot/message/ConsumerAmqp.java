package kr.purred.playground.startboot.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ConsumerAmqp
{
	private static final Logger log = LoggerFactory.getLogger (ConsumerAmqp.class);

	@RabbitListener(queues = "spring-boot")
	public void handler (String message)
	{
		log.info ("래빗 소비기> " + message);
	}
}
