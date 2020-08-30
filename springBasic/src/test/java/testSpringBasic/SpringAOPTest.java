package testSpringBasic;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import idv.jay.proxy.Imath;
import idv.jay.proxy.MathImpl;
import idv.jay.proxy.ProxyUtil;

public class SpringAOPTest {
	
	@Test
	public void testProxy() {
		ProxyUtil proxy = new ProxyUtil(new MathImpl());
		Imath math = (Imath) proxy.getProxy();
		math.add(1, 2);
	}
	
	@Test
	public void testAspectJ() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Imath math = context.getBean("mathImpl", Imath.class);
		math.testSpringAop();
	}
}
