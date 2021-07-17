package org.lzn.abstractfactory;

import org.lzn.Fruit;

/**
 * <p>
 * 抽象工厂模式，工厂接口
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-17 16:33
 */
public interface Factory {
    /**
     * 生产水果
     *
     * @return org.lzn.Fruit 水果
     * @author LinZhenNan lin_hehe@qq.com
     * @since 2021-07-17 16:35
     */
    Fruit createFruit();
    
    /**
     * 生产种子
     *
     * @return org.lzn.abstractfactory.Seed 种子
     * @author LinZhenNan lin_hehe@qq.com 
     * @since 2021-07-17 16:36
     */
    Seed createSeed();
}
