package kr.purred.playground.startboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/test")
public class Test2Ct
{
	@GetMapping ("/re")
	public String reTest (
	)
	{
		return "redirect:http://www.naver.com";
	}
}
