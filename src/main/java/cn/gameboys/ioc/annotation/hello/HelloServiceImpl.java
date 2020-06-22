package cn.gameboys.ioc.annotation.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 注解@Component表明该类会作为组件类，并告知spring要为这个类创建bean。
 */
@Component
public class HelloServiceImpl implements HelloService,ApplicationListener<ContextRefreshedEvent>{
    /** 测试自动装配 */
    @Autowired
    private HappyNewYear happyNewYear;

    /*@Autowired
    public HelloServiceImpl(HappyNewYear happyNewYear) {
        this.happyNewYear = happyNewYear;
    }*/

    public void testAutowired() {
        happyNewYear.sayHappyNewYear();
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello:" + name);
    }

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("@@@@@@@onApplicationEvent");
	}
}
