package org.lzn.factorymethod;

import org.lzn.Apple;
import org.lzn.Fruit;

/**
 * <p>
 * 工厂方法模式，苹果工厂
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-15 23:02
 */
public class AppleFactory implements Factory {
    @Override
    public Fruit create() {
        // 复杂的构建逻辑
        return new Apple();
    }
}
