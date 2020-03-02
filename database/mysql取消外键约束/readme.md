# 取消 Mysql 外键约束

默认会话变量。

```sql
-- 查看外检约束的值
SELECT @@FOREIGN_KEY_CHECKS; 

-- 取消外键约束
SET FOREIGN_KEY_CHECKS=0;

-- 操作

-- 设置外键约束
SET FOREIGN_KEY_CHECKS=1;
```

全局外检约束

```sql
-- 查看外检约束的值
SELECT @@GLOBAL.FOREIGN_KEY_CHECKS;

-- 取消全局外键约束
SET GLOBAL FOREIGN_KEY_CHECKS=0;

-- 操作

-- 设置全局外键约束
SET GLOBAL FOREIGN_KEY_CHECKS=1;
```

