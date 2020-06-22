package cn.gameboys.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		// 得到的是carBean
		System.out.println(context.getBean("carFactoryBean"));
		// 得到的是carBean工厂
		System.out.println(context.getBean("&carFactoryBean"));
		
		//ApplicationContext  BeanFactory  XmlBeanFactory
	}
}
