package org.lzn.abstractfactory;

import org.lzn.Fruit;
import org.lzn.Pear;

/**
 * <p>
 * 抽象工厂模式，梨子工厂
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-17 16:40
 */
public class PearFactory implements Factory {
    @Override
    public Fruit createFruit() {
        // 复杂的构建逻辑
        return new Pear();
    }

    @Override
    public Seed createSeed() {
        // 复杂的构建逻辑
        return new PearSeed();
    }
}
