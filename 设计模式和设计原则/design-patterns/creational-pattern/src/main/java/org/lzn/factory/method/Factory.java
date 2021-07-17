package org.lzn.factory.method;

/**
 * <p>
 * 工厂方法模式，工厂接口
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-15 22:56
 */
public interface Factory {
    /**
     * 创建水果
     *
     * @return 创建的水果
     * @author LinZhenNan lin_hehe@qq.com
     * @since 2021-07-15 23:00
     */
    Fruit create();
}
