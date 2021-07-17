package org.lzn;

/**
 * <p>
 * 苹果
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-13 22:42
 */
public class Apple implements Fruit {
    public Apple() {
        // 复杂的构建过程
    }

    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}
