package org.lzn.builder;

import org.lzn.Apple;
import org.lzn.Fruit;
import org.lzn.Pear;

/**
 * <p>
 * 苹果拼盘
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-09-16 21:59
 */
public class ApplePlatter {
    /**
     * 主材料：苹果
     */
    private Apple apple;

    /**
     * 第一种辅助材料。第一种赋值材料含量比第二种多
     */
    private Fruit firstSubsidiary;

    /**
     * 第二种辅助材料
     */
    private Fruit secondSubsidiary;

    private ApplePlatter() {
        apple = new Apple();
        firstSubsidiary = new Pear();
    }

    /**
     * <p>
     * 苹果拼盘构建者
     * </p>
     *
     * @author LinZhenNan lin_hehe@qq.com
     * @since 2021-09-16 22:09
     */
    static class Builder {
        /**
         * 水果拼盘
         */
        private ApplePlatter applePlatter;

        private Builder() {
            applePlatter = new ApplePlatter();
        }

        /**
         * 创建构建者
         *
         * @return org.lzn.builder.ApplePlatter.Builder
         * @author LinZhenNan lin_hehe@qq.com
         * @since 2021-09-16 22:09
         */
        public static Builder create() {
            return new Builder();
        }

        /**
         * 指定第一种辅料
         *
         * @param firstSubsidiary 第一种辅料
         * @return org.lzn.builder.ApplePlatter.Builder
         * @author LinZhenNan lin_hehe@qq.com
         * @since 2021-09-16 22:10
         */
        public Builder setFirstSubsidiary(Fruit firstSubsidiary) {
            this.applePlatter.firstSubsidiary = firstSubsidiary;
            return this;
        }

        /**
         * 指定第二种辅料
         *
         * @param secondSubsidiary 第二种辅料
         * @return org.lzn.builder.ApplePlatter.Builder
         * @author LinZhenNan lin_hehe@qq.com
         * @since 2021-09-16 22:10
         */
        public Builder setSecondSubsidiary(Fruit secondSubsidiary) {
            this.applePlatter.secondSubsidiary = secondSubsidiary;
            return this;
        }

        /**
         * 构建水果拼盘对象
         *
         * @return org.lzn.builder.ApplePlatter
         * @author LinZhenNan lin_hehe@qq.com
         * @since 2021-09-16 22:10
         */
        public ApplePlatter build() {
            return this.applePlatter;
        }
    }
}
