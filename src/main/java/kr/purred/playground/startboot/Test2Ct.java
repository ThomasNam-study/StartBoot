package kr.purred.playground.startboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test2Ct
{
	@GetMapping ("/re")
	public String reTest (
	)
	{
		return "redirect:http://www.naver.com";
	}
}
