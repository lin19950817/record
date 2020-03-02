# MySQL 中的事务

1. MySQL 引擎是支持事务的

2. MySQL 默认自动提交事务。每条语句都处在单独的事务中

3. 手动控制事务

   ```sql
   -- 开启事务
   BEGIN;
   -- 或者
   start TRANSACTION;
   
   -- 提交事务
   COMMIT;
   
   -- 回滚事务
   ROLLBACK;
   ```

##  事务的隔离级别

1. 查看当前的事务隔离级别 

   ```sql
   select @@TX_ISOLATION;
   ```


2. 更改当前的事务隔离级别。设置隔离级别必须在事务之前。

   ```sql
   -- 更改当前的事务隔离级别为 读未提交（read uncommitted）
   set transaction isolation level read uncommitted;
   ```

    