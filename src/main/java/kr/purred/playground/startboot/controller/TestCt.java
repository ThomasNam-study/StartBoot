package kr.purred.playground.startboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.purred.playground.startboot.data.UdiaMemberCallbackCompany;
import kr.purred.playground.startboot.data.UdiaMemberCallbackPersonal;
import kr.purred.playground.startboot.message.ProducerAmqp;

@RestController
@RequestMapping("/test")
public class TestCt
{
	@Autowired ProducerAmqp producer;

	@GetMapping("/amqp")
	public String producer ()
	{
		producer.sendTo ("spring-boot", "데이터 발행했습니다요");

		return "OK";
	}

	@GetMapping("/company")
	public UdiaMemberCallbackCompany getCompany (
		@RequestParam("memberID") String memberID
	)
	{
		System.out.println ("memberID : " + memberID);

		UdiaMemberCallbackCompany company = new UdiaMemberCallbackCompany ();;

		company.setCeoName ("남대표");
		company.setCompanyName ("개똥회사");
		company.setBankName ("국민은행");

		return company;
	}

	@GetMapping("/personal")
	public UdiaMemberCallbackPersonal getPersonal (
		@RequestParam("memberID") String memberID
	)
	{
		System.out.println ("memberID : " + memberID);

		UdiaMemberCallbackPersonal company = new UdiaMemberCallbackPersonal ();;

		company.setName ("사유리");
		company.setBankName ("국민은행");

		return company;
	}


}
