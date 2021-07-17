package org.lzn.abstractfactory;

/**
 * <p>
 * 梨子种子
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-17 16:38
 */
public class PearSeed implements Seed {
    @Override
    public void grow() {
        System.out.println("梨子种子发芽");
    }
}
