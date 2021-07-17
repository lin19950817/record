package org.lzn.abstractfactory;

import org.lzn.Apple;
import org.lzn.Fruit;

/**
 * <p>
 * 抽象工厂模式，苹果工厂
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-17 16:38
 */
public class AppleFactory implements Factory {
    @Override
    public Fruit createFruit() {
        // 复杂的构建逻辑
        return new Apple();
    }

    @Override
    public Seed createSeed() {
        // 复杂的构建逻辑
        return new AppleSeed();
    }
}
