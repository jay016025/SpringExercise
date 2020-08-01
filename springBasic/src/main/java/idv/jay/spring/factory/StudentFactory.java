package idv.jay.spring.factory;

import org.springframework.beans.factory.FactoryBean;

import idv.jay.spring.model.Student;
/**
 * 練習實作FactoryBean
 * 學生工廠
 * @author 凱傑
 *
 */
public class StudentFactory implements FactoryBean<Student>{
	/**
	 * 創建學生物件
	 */
	@Override
	public Student getObject() throws Exception {
		Student student = new Student();
		student.setName("admin");
		student.setSex("Unknow");
		return student;
	}
	
	/**
	 * 取得學生型別
	 */
	@Override
	public Class<?> getObjectType() {
		return Student.class;
	}
	
	/**
	 * 是否為Singleton
	 */
	@Override
	public boolean isSingleton() {
		return false;
	}

}
