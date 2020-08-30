package idv.jay.afterHandler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class AfterHandler implements BeanPostProcessor{
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		
		System.out.println("此為後置處理器在" + beanName + "初始化前所做的事情");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		System.out.println("此為後置處理器在" + beanName + "初始化後所做的事情");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
}
