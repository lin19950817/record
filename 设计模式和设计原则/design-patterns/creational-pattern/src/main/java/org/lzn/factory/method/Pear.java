package org.lzn.factory.method;

/**
 * <p>
 * 梨
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-13 22:42
 */
public class Pear implements Fruit {
    public Pear() {
        // 复杂的构建过程
    }

    @Override
    public void eat() {
        System.out.println("吃梨");
    }
}
