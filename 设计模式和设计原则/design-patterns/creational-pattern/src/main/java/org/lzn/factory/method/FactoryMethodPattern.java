package org.lzn.factory.method;

/**
 * <p>
 * 工厂方法模式
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-15 23:04
 */
public class FactoryMethodPattern {
    public static void main(String[] args) {
        // 生成苹果
        Factory appleFactory = new AppleFactory();
        Fruit apple = appleFactory.create();
        apple.eat();

        // 生成梨
        Factory pearFactory = new PearFactory();
        Fruit pear = pearFactory.create();
        pear.eat();
    }
}
