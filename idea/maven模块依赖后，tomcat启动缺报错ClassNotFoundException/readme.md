# maven模块依赖后，tomcat启动缺报错ClassNotFoundException

`tomcat` 启动都可以按这个方法添加 `jar`，在 **解决的步骤3** 中 `WEB-INF` 下新建 `lib` 文件夹，在此文件夹里添加 `jar`。

## 现象

1. 父工程下两个 maven 工程

   ![models](../images/maven/mavenTwo.png)

2. `pom` 依赖，`session` 工程依赖 `cookie` 

   ![pom](../images/maven/mavenTwoPom.png)

3. 错误

   ![error](../images/mavenClassNotFoundException.png)

## 解决

1. 进入 `Project Structure`。**File -> Project Structure**

   ![projectStructure](../images/ProjectStructure.png)

2. 进入 `Artifacts` 为 `session` 添加 `Output Layout`。

   ![project structure](../images/projectStructure/mavenTwoArtifacts.png)

   ![layout](../images/projectStructure/mavenTwoOutput.png)

   ![choose](../images/projectStructure/mavenTwoChooseModule.png)

3. 结果

   ![end](../images/projectStructure/mavenTwoEnd.png)