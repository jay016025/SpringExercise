package testSpringBasic;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import idv.jay.spring.model.Person;
import idv.jay.spring.model.Student;
import idv.jay.spring.model.Teacher;

public class SpringIOCTest {
	
	@Test
	public void testJunit() {
		Person mo = new Person();
		mo.setId(001);
		System.out.println(mo);
	}
	
	@Test
	public void testBean() {
//		初始化容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		透過beanId取得物件
//		Person mo = (Person) context.getBean("firstBean");
		
		/*透過class取得物件
		 * 使用此方法取得物件須注意此類型物件只能有一個
		 */
//		Person mo = context.getBean(Person.class);
		
		/*
		 * 透過id、class取得bean
		 */
		Student mo = context.getBean("s6", Student.class);
		Teacher th = context.getBean("t5", Teacher.class);
		System.out.println(th);
	}
	
	@Test
	public void testFactoryBean() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object obj = context.getBean("studentFactory");
		//工廠bean特點:這裡取得的物件應該為工廠，但是實際上為工廠所創建的物件
		System.out.println(obj);
	}
}
