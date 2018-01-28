package kr.purred.playground.startboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.purred.playground.startboot.message.ProducerWs;

@RestController
@RequestMapping("/test")
public class WebSocketController
{
	@Autowired ProducerWs producerWs;

	@GetMapping("/ws")
	public ModelAndView ws (ModelAndView mv)
	{
		mv.setViewName ("ws");

		return mv;
	}

	@RequestMapping("/send/{topic}")
	public String sender (@PathVariable("topic") String topic, @RequestParam String message)
	{
		producerWs.sendTo (topic, message);

		return "OK";
	}
}
