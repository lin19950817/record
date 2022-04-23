# 建造者模式（Builder Pattern）

> 创建者模式又叫建造者模式，是将一个复杂的对象的 **构建** 与它的 **表示** 分离，使得同样的构建过程可以创建不同的表示。创建者模式隐藏了复杂对象的创建过程，它把复杂对象的创建过程加以抽象，通过子类继承或者重载的方式，动态的创建具有复合属性的对象。

## 特点

减低创建复杂对象的复杂度

对象的构建和表示分离

建造者可以对创建过程逐步细化，而不对其它模块产生任何影响，便于控制细节风险。

## 示例

制作招牌苹果拼盘，主材料是苹果，辅料是梨子。后来又研发出 **苹果+香蕉** 的苹果拼盘，**苹果+梨子+香蕉** 的苹果拼盘。相同辅料但含量不同制作出来的苹果拼盘也不同。这时使用构建者模式。

**[苹果拼盘](design-patterns/creational-pattern/src/main/java/org/lzn/builder/ApplePlatter.java)**

```java
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

```

**[苹果](design-patterns/creational-pattern/src/main/java/org/lzn/Apple.java)**

```java
/**
 * <p>
 * 苹果
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-13 22:42
 */
public class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}
```

**[水果](design-patterns/creational-pattern/src/main/java/org/lzn/Fruit.java)**

```java
/**
 * <p>
 * 水果
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-13 22:41
 */
public interface Fruit {
    /**
     * 吃
     *
     * @author LinZhenNan lin_hehe@qq.com
     * @since 2021-07-15 22:58
     */
    void eat();
}
```

**[梨子](design-patterns/creational-pattern/src/main/java/org/lzn/Pear.java)**

```java
/**
 * <p>
 * 梨
 * </p>
 *
 * @author LinZhenNan lin_hehe@qq.com
 * @since 2021-07-13 22:42
 */
public class Pear implements Fruit {
    @Override
    public void eat() {
        System.out.println("吃梨");
    }
}
```

**[构建者](design-patterns/creational-pattern/src/main/java/org/lzn/builder/BuilderPattern.java)**

```java
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
```

## 应用场景

- 相同的方法，不同的执行顺序，产生不同的结果。
- 多个部件或零件，都可以装配到一个对象中，但是产生的结果又不相同。
- 产品类非常复杂，或者产品类中不同的调用顺序产生不同的作用。
- 初始化一个对象特别复杂，参数多，而且很多参数都具有默认值。