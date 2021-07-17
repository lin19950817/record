package org.lzn.factorymethod;

import org.lzn.Apple;
import org.lzn.Fruit;
import org.lzn.Pear;

/**
 * <p>
 * 简单工厂模式，水果工厂
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-13 22:43
 */
public class FruitFactory {
    public static final String APPLE = "苹果";
    public static final String PEAR = "梨";
    private FruitFactory() {
    }

    /**
     * 创建指定的水果
     *
     * @param fruitName 指定创建那种水果
     * @return 指定的水果
     * @author LinZhenNan lin_hehe@qq.com
     * @since 2021-07-15 23:01
     */
    public static Fruit create(String fruitName) {
        switch (fruitName) {
            case APPLE:
                return new Apple();
            case PEAR:
                return new Pear();
            default:
                throw new RuntimeException("不能存在水果：" + fruitName);
        }
    }
}
