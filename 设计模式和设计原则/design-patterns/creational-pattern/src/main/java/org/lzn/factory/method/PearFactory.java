package org.lzn.factory.method;

/**
 * <p>
 * 工厂方法模式，梨子工厂
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-15 23:02
 */
public class PearFactory implements Factory {
    @Override
    public Fruit create() {
        return new Pear();
    }
}
