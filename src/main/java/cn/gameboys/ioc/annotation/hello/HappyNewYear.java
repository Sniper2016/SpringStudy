package cn.gameboys.ioc.annotation.hello;

import org.springframework.stereotype.Component;

@Component
public class HappyNewYear {
    public void sayHappyNewYear() {
        System.out.println("Happy New Year!");
    }
}
