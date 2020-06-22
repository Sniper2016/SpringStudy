
package cn.gameboys.diy.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
* @Description: 
* @author: sniper(1084038709@qq.com)
* @date:2020年6月22日 上午11:11:49
 */
public class MainTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:diy-config.xml");
		UserConfig userconfig = (UserConfig) context.getBean("testDiy");
		System.out.println(userconfig);
		//org.springframework.aop.config.AopNamespaceHandler cn.gameboys.diy.ioc.DiyHandlers

	}
}
