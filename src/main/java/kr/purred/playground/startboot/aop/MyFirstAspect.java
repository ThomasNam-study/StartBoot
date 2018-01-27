package kr.purred.playground.startboot.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyFirstAspect
{
	@Before ("execution(* findAll())")
	public void before()
	{
		System.out.println ("Hello before! *** 메서드가 호출되기 전에 나온다.");
	}
}
