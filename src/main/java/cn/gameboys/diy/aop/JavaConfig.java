package cn.gameboys.diy.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月22日 下午3:22:42
 */
@Configuration
@ComponentScan("cn.gameboys.diy.aop")
public class JavaConfig {

	@MyAspect(pointCut = "cn.gameboys.diy.aop.TestBean.test")
	public static class MyAspectClass {

		void before(Object[] args) {
			System.out.println("aop before");
		}

		void after(Object[] args) {
			System.out.println("aop after");
		}

		void around(MethodInvocation methodInvocation, Object[] args) throws Throwable {
			System.out.println("aop around before");
			methodInvocation.proceed(methodInvocation);
			System.out.println("aop around after");
		}
	}

	@Bean
	public CustomizeAspectProxy getCustomizeAspectScan() {
		return new CustomizeAspectProxy();
	}


}
