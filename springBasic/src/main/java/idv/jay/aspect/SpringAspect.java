package idv.jay.aspect;

import org.springframework.stereotype.Component;

@Component
public class SpringAspect {
	
	public void before() {
		System.out.println("Spring_AOP: 前置通知");
	}
}
