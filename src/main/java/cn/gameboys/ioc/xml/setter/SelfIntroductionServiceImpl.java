package cn.gameboys.ioc.xml.setter;

import cn.gameboys.ioc.xml.common.HelloService;

public class SelfIntroductionServiceImpl implements SelfIntroductionService {
    private HelloService helloService;

    // setter方式注入Bean
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void selfIntroduction() {
        // 向大家打招呼
        helloService.sayHello("大家好!");
    }

}
