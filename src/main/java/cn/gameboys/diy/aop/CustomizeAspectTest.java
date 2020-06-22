package cn.gameboys.diy.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月22日 下午3:22:42
 */
public class CustomizeAspectTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.register(JavaConfig.class);
		annotationConfigApplicationContext.refresh();
		TestBean test = annotationConfigApplicationContext.getBean(TestBean.class);
		test.test();
	}

}
