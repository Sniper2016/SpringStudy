package cn.gameboys.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("scope-test.xml");
		User user = context.getBean("zs",User.class);
		User user2 = context.getBean("zs",User.class);
		System.out.println("两个对象是否相等？："+user.equals(user2));
		
		User user3 = context.getBean("lisi",User.class);
		User user4 = context.getBean("lisi",User.class);
		System.out.println("两个对象是否相等？："+user3.equals(user4));
		
		
		
	
	}
}
