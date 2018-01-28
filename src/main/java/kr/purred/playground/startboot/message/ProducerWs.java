package kr.purred.playground.startboot.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProducerWs
{
	private static final Logger log = LoggerFactory.getLogger (ProducerWs.class);

	private final SimpMessagingTemplate template;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat ("MM/dd/yyyy HH:mm:ss");

	public void sendTo (String topic, String message)
	{
		log.info ("전송 웹소켓> ...");

		StringBuilder sb = new StringBuilder ();

		sb.append ("[").append (dateFormat.format (new Date ())).append ("] ").append (message);

		template.convertAndSend ("/topic/" + topic, sb.toString ());
	}
}
