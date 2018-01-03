package kr.purred.playground.startboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.purred.playground.startboot.data.UdiaMemberCallbackCompany;
import kr.purred.playground.startboot.data.UdiaMemberCallbackPersonal;

@RestController
public class TestCt
{
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
