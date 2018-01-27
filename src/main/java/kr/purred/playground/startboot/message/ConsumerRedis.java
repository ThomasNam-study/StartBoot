package kr.purred.playground.startboot.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ConsumerRedis
{
	private static final Logger log = LoggerFactory.getLogger (ConsumerRedis.class);

	public void messageHandler (String message)
	{
		log.info ("소비기> " + message);
	}
}
