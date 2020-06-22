package cn.gameboys.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTask {

	// 两种方案，一种是通过正则表达，另外是通过注解
/*
	@Pointcut("execution(* cn.gameboys.aop.test.Main.delayTask2(..))")
	public void task() {
	}

	@Around("task()")
	public void testAround(ProceedingJoinPoint jp) {

		try {
			System.out.println("1111111111111");
			System.out.println("2222222222222");
			jp.proceed();
			System.out.println("3333333333333");
		} catch (Throwable e) {
			System.out.println("开会不爽，打起来了");
		}

		TimerScheduler.getInstance().doLater(new CommonAction(jp) {

			@Override
			public void run() {
				ProceedingJoinPoint jp = (ProceedingJoinPoint) params[0];
				try {
					jp.proceed();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}, 1000);
	}

	@Around("@annotation(cn.gameboys.aop.test.AsynTask)")
	public void testAround2(ProceedingJoinPoint jp) {
		TimerScheduler.getInstance().doLater(new CommonAction(jp) {
			@Override
			public void run() {
				ProceedingJoinPoint jp = (ProceedingJoinPoint) params[0];
				try {
					jp.proceed();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}, 1000);
	}
	
	*/
	
	
	
	

	@Pointcut("@annotation(cn.gameboys.aop.test.AsynTask)")
	public void task() {
	}

	


	@Around("task()")
	public void testAround(ProceedingJoinPoint jp) {
		TimerScheduler.getInstance().doLater(new CommonAction(jp) {
			@Override
			public void run() {
				ProceedingJoinPoint jp = (ProceedingJoinPoint) params[0];
				try {
					jp.proceed();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}, 1000);
	}
	
	
	
	
	
	
	
	

}
