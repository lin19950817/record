package org.lzn.abstractfactory;

/**
 * <p>
 * 苹果种子
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-17 16:37
 */
public class AppleSeed implements Seed {
    @Override
    public void grow() {
        System.out.println("苹果种子发芽");
    }
}
