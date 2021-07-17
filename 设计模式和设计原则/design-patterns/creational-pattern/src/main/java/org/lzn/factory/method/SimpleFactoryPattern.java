package org.lzn.factory.method;

/**
 * <p>
 * 简单工厂模式
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-12 17:29
 */
public class SimpleFactoryPattern {

    public static void main(String[] args) {
        // 不关注苹果和梨的构造过程，种植水果所需要的阳光水分
        Fruit apple = FruitFactory.create(FruitFactory.APPLE);
        Fruit pear = FruitFactory.create(FruitFactory.PEAR);
        // 关注他们的方法
        apple.eat();
        pear.eat();
    }
}
