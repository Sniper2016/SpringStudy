package cn.gameboys.aop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 本例为注解实现异步执行
 * 
 * @Description:
 * @author: sniper(1084038709@qq.com)
 * @date:2019年6月11日 下午12:26:22
 */
@Service
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Main main = context.getBean(Main.class);
		
	//	main.delayTask1();
		
		main.delayTask2(30063, 666666);
		
		
		//org.springframework.aop.config.AopNamespaceHandler
		
	}

	public void delayTask1() {
		TimerScheduler.getInstance().doLater(new CommonAction(31063, 666666) {
			@Override
			public void run() {
				Integer gameID = (int) params[0];
				Integer userID = (int) params[1];
				System.out.println(Thread.currentThread().getName() + " " + gameID + " " + userID);
			}
		}, 1000);
	}

	@AsynTask
	public void delayTask2(int gameID, int userID) {
		System.out.println(Thread.currentThread().getName() + " " + gameID + " " + userID);
	}

}
