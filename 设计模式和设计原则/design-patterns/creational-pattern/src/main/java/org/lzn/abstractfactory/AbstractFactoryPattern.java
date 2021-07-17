package org.lzn.abstractfactory;

import org.lzn.Fruit;

/**
 * <p>
 * 抽象工厂模式
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-17 16:32
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // 水果系列
        Factory appleFactory = new AppleFactory();
        Fruit apple = appleFactory.createFruit();
        Seed appleSeed = appleFactory.createSeed();

        // 梨子系列
        Factory pearFactory = new PearFactory();
        Fruit pear = pearFactory.createFruit();
        Seed pearSeed = pearFactory.createSeed();
    }
}
