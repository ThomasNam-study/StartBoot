package kr.purred.playground.startboot.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProducerAmqp
{
	private static final Logger log = LoggerFactory.getLogger (ProducerAmqp.class);

	@Autowired RabbitTemplate rabbitTemplate;

	public void sendTo (String routingKey, String message)
	{
		log.info ("레빗 전송 > ...");

		this.rabbitTemplate.convertAndSend (routingKey, message);
	}
}
