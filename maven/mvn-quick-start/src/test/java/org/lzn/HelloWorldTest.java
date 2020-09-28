package org.lzn;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * HelloWorld 测试
 *
 * @author LinZhenNan lin_hehe@qq.com 2020/09/16 22:17
 */
public class HelloWorldTest {

    @Test
    public void sayHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        String hello = helloWorld.sayHelloWorld("hehe");
        assertEquals("hehe, HelloWorld！", hello );
    }
}