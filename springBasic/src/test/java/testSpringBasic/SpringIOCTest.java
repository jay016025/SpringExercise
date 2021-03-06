package testSpringBasic;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import idv.jay.EmpModel.EmpController.EmpController;
import idv.jay.lifeCycle.LifeCycle;
import idv.jay.spring.model.Emp;
import idv.jay.spring.model.Person;
import idv.jay.spring.model.Student;
import idv.jay.spring.model.Teacher;

public class SpringIOCTest {
	
	private ApplicationContext context;
	
	@BeforeEach
	public void setup() {
//		初始化容器
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	@Test
	public void testJunit() {
		Person mo = new Person();
		mo.setId(001);
		System.out.println(mo);
	}
	
	@Test
	public void testBean() {
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
		Object obj = context.getBean("studentFactory");
		//工廠bean特點:這裡取得的物件應該為工廠，但是實際上為工廠所創建的物件
		System.out.println(obj);
	}
	
	@Test
	public void testLifeCycle() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LifeCycle msg = context.getBean("lifeCycle", LifeCycle.class);
		System.out.println(msg);
		context.close();
	}
	
	@Test
	public void testDataSource() throws SQLException {
		ComboPooledDataSource dataSource = context.getBean("dataSource", ComboPooledDataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testEmpAutoWrite() {
		
		Emp emp = context.getBean("emp", Emp.class);
		System.out.println(emp);
	}
	
	@Test
	public void testAnnotation() {
		System.out.println(this.context);
	}
	
	@Test
	public void testController() {
		EmpController controller = context.getBean("empController", EmpController.class);
		controller.addEmp();
	}
}
