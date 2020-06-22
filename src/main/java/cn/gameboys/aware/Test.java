package cn.gameboys.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aware-test.xml");

		User user = context.getBean(User.class);
		System.out.println(String.format("实现了BeanNameAware接口的信息BeanId=%s,所有信息=%s", user.getId(), user.toString()));

		User2 user2 = context.getBean(User2.class);
		System.out.println(String.format("未实现BeanNameAware接口的信息BeanId=%s,所有信息=%s", user2.getId(), user2.toString()));
	}
}
