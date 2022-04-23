package org.lzn.builder;

import org.lzn.Pear;

/**
 * <p>
 * 建造者模式
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-20 20:02
 */
public class BuilderPattern {
    public static void main(String[] args) {
        // 使用构建者模式构建苹果拼盘。苹果+梨子
        ApplePlatter applePlatter = ApplePlatter.Builder.create().setSecondSubsidiary(new Pear()).build();
    }
}
