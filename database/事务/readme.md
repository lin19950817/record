# 数据库事务（ Database Transaction ）

## 事务的特性

1. <a href="#atomicity">原子性（atomicity）</a>
2. <a href="#consistency">一致性（consistency）</a>
3. <a href="#isolation">隔离性（isolation）</a>
4. <a href="#durability">持久性（durability）</a>

### <a name="atomicity" style="text-decoration:none">原子性</a>

指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。

### <a name="consistency" style="text-decoration:none">一致性</a>

事务必须使数据库从一个一致性状态变换到另外一个一致性状态。转账前和转账后的总金额不变。

### <a name="isolation" style="text-decoration:none">隔离性</a>

事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。例如，在A事务中，查看另一B事务(正在修改张三的账户金额)中张三的账户金额，要查看到B事务之前的张三的账户金额，要么查看到B事务之后张三的账户金额。事务隔离性分等级。

### <a name="durability" style="text-decoration:none">持久性</a>

指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发生故障也不应该对其有任何影响。

## 事务的隔离级别

大多数数据库默认的事务隔离级别是Read committed，比如Sql Server , Oracle。Mysql的默认隔离级别是Repeatable read。

1. <a href="#readUncommitted">Read uncommitted</a>
2. <a href="#readCommitted">Read committed</a>
3. <a href="#repeatableRead">Repeatable read</a>
4. <a href="#serializable">Serializable</a>

以上隔离级别是为了防止一下情况的发生

1. <a href="#dirtyReading">脏读</a>
2. <a href="#nonRepeatableReading">不可重复读</a>
3. <a href="#unrealReading">幻读（虚读）</a>

### <a name="readUncommitted" style="text-decoration:none">Read uncommitted</a>

**读未提交**。就是一个事务可以读取另一个未提交事务的数据。 

#### 实例

老板要给程序员发工资，程序员的工资是3.6万/月。但是发工资时老板不小心按错了数字，按成3.9万/月，该钱已经打到程序员的户口，但是事务还没有提交，就在这时，程序员去查看自己这个月的工资，发现比往常多了3千元，以为涨工资了非常高兴。但是老板及时发现了不对，马上回滚差点就提交了的事务，将数字改成3.6万再提交。

#### 分析

实际程序员这个月的工资还是3.6万，但是程序员看到的是3.9万。他看到的是老板还没提交事务时的数据。这就是 **脏读**。

### <a name="readCommitted" style="text-decoration:none">Read committed</a>

**读提交**。就是一个事务要等另一个事务提交后才能读取数据。 

#### 实例

程序员拿着信用卡去享受生活（卡里当然是只有3.6万），当他埋单时（程序员事务开启），收费系统事先检测到他的卡里有3.6万，就在这个时候！！程序员的妻子要把钱全部转出充当家用，并提交。当收费系统准备扣款时，再检测卡里的金额，发现已经没钱了（第二次检测金额当然要等待妻子转出金额事务提交完）。程序员就会很郁闷，明明卡里是有钱的…

#### 分析

这就是读提交，若有事务对数据进行更新（UPDATE）操作时，读操作事务要等待这个更新操作事务提交后才能读取数据，可以解决 **脏读** 问题。但在这个事例中，出现了一个事务范围内两个相同的查询却返回了不同数据，这就是 **不可重复读**。

### <a name="repeatableRead" style="text-decoration:none">Repeatable read</a>

**重复读**。就是在开始读取数据（事务开启）时，不再允许修改操作。

#### 实例

程序员拿着信用卡去享受生活（卡里当然是只有3.6万），当他埋单时（事务开启，不允许其他事务的UPDATE修改操作），收费系统事先检测到他的卡里有3.6万。这个时候他的妻子不能转出金额了。接下来收费系统就可以扣款了。

#### 分析

重复读可以解决 **不可重复读** 问题。写到这里，应该明白的一点就是，**不可重复读** 对应的是修改，即UPDATE操作。但是可能还会有 **幻读** 问题。因为 **幻读** 问题对应的是插入INSERT操作，而不是UPDATE操作。

### <a name="serializable" style="text-decoration:none">Serializable</a>

Serializable 是最高的事务隔离级别，在该级别下，事务串行化顺序执行，可以避免 **脏读、不可重复读与幻读**。但是这种事务隔离级别效率低下，比较耗数据库性能，一般不使用。

### <a name="dirtyReading" style="text-decoration:none">脏读</a>

指一个事务读取了另一个事务未提交的数据

### <a name="unrealReading" style="text-decoration:none">不可重复读</a>

在一个事务内读取表中的某一行数据，多次读取结果不同。一个事务读取到了另一个事务提交后的数据。（update）

### <a name="nonRepeatableReading" style="text-decoration:none">幻读（虚读）</a>

指一个事务内读取到了别的事务插入的数据，导致前后读取不一致。（insert）

#### 实例

程序员某一天去消费，花了2千元，然后他的妻子去查看他今天的消费记录（全表扫描FTS，妻子事务开启），看到确实是花了2千元，就在这个时候，程序员花了1万买了一部电脑，即新增INSERT了一条消费记录，并提交。当妻子打印程序员的消费记录清单时（妻子事务提交），发现花了1.2万元，似乎出现了幻觉，这就是 **幻读**。
