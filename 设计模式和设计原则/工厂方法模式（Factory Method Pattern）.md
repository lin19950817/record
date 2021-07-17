# 工厂方法模式（Factory Method Pattern）

[TOC]

## 工厂模式

工厂模式是用于封装对象的设计模式。当创建一个类的时候，通过工厂类来创建对象，调用方无需关注对象创建过程，只关注对象的使用。

## 作用

* 减低维护成本。创建对象的过程发生变化时，只需要修改工厂的创建逻辑
* 解耦。对象的创建和使用分开，调用方不关心对象的创建过程
* 减低代码重复。如果构建过程复杂，而每次创建都要重复代码

## <a name="simpleFactory" style="text-decoration:none">简单工厂模式（Simple Factory Pattern）</a>

简单工厂模式中用于被创建实例的方法通常为 **静态方法**，因此简单工厂模式又被称为 **静态工厂方法**。

在 GoF 所著的《设计模式》一书中，简单工厂模式被划分为工厂方法模式的一种特例，没有单独被列出来。

例子，当我们需要一个苹果时，我们需要知道苹果的构造过程；需要一个梨时，我们需要知道梨的构造过程。如果存在一个水果工厂，而我们只需要告诉工厂我们需要什么样的水果，让工厂提供我们需要的水果就方便多了，我们无需知道水果怎么种，梨有需要怎么种。

[水果工厂](design-patterns/creational-pattern/src/main/java/org/lzn/factory/method/FruitFactory.java)

```java
public class FruitFactory {
    public static final String APPLE = "苹果";
    public static final String PEAR = "梨";
    public static Fruit create(String fruitName) {
        switch (fruitName) {
            case APPLE:
                return new Apple();
            case PEAR:
                return new Pear();
            default:
                throw new RuntimeException("不能存在水果：" + fruitName);
        }
    }
}
```

使用时，[调用方](design-patterns/creational-pattern/src/main/java/org/lzn/factory/method/SimpleFactoryPattern.java)：

```java
public class SimpleFactoryPattern {
    public static void main(String[] args) {
        // 不关注苹果和梨的构造过程，种植水果所需要的阳光、水分等
        Fruit apple = FruitFactory.create(FruitFactory.APPLE);
        Fruit pear = FruitFactory.create(FruitFactory.PEAR);
        // 关注他们的方法
        apple.eat();
        pear.eat();
    }
}
```

此时构造过程发生变化，例如，添加肥料能使果实更香甜，此时只需要修改工厂。调用方代码无需修改。

[水果](design-patterns/creational-pattern/src/main/java/org/lzn/factory/method/Fruit.java)

```java
public interface Fruit {
    void eat();
}
```

[苹果](design-patterns/creational-pattern/src/main/java/org/lzn/factory/method/Apple.java)

```java
public class Apple implements Fruit {
    public Apple() {
        // 复杂的构建过程
    }
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}
```

[梨](design-patterns/creational-pattern/src/main/java/org/lzn/factory/method/Pear.java)

```java
public class Pear implements Fruit {
    public Pear() {
        // 复杂的构建过程
    }
    @Override
    public void eat() {
        System.out.println("吃梨");
    }
}
```

## 工厂方法模式（Factory Method Pattern）

简单工厂模式存在一些问题，一旦添加生产产品的种类，例如添加香蕉就得修改工厂类添加新分支，**这就违背了开闭原则**，并且当生产的种类越来越多时，**工厂类就会变成超级类**，越来越大，越来越臃肿。

为了解决这两个弊端，工厂方法模式规定每个产品都有一个专属工厂。例如，苹果有专属苹果的工厂，梨子有专属梨子的工厂。

[工厂接口](design-patterns/creational-pattern/src/main/java/org/lzn/factory/method/Factory.java)，定义统一规范

```java
public interface Factory {
    Fruit create();
}
```

[苹果工厂](design-patterns/creational-pattern/src/main/java/org/lzn/factory/method/AppleFactory.java)

```java
public class AppleFactory implements Factory {
    @Override
    public Fruit create() {
        return new Apple();
    }
}
```

[梨子工厂](design-patterns/creational-pattern/src/main/java/org/lzn/factory/method/PearFactory.java)

```java
public class PearFactory implements Factory {
    @Override
    public Fruit create() {
        return new Pear();
    }
}
```

[使用时](design-patterns/creational-pattern/src/main/java/org/lzn/factory/method/FactoryMethodPattern.java)

```java
public class FactoryMethodPattern {
    public static void main(String[] args) {
        // 生成苹果
        Factory appleFactory = new AppleFactory();
        Fruit apple = appleFactory.create();
        apple.eat();

        // 生成梨
        Factory pearFactory = new PearFactory();
        Fruit pear = pearFactory.create();
        pear.eat();
    }
}
```

当有新的生产产品种类时，只需要添加新的工厂，符合 **开闭原则**。工厂类也不会变成超级类，符合 **单一原则**。