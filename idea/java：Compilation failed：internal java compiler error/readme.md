## java: Compilation failed: internal java compiler error
Error:java: Compilation failed: internal java compiler error<br>
![内部java编译错误](../images/message/internalJavaCompilerError.png)
### 原因
导致这个错误的原因主要是因为jdk版本问题。编译版本不匹配。
### 解决
1. 进入设置。 **File -> Settings**。<br>
![设置](../images/setting.png)
2. 进入 java 编译，选择编译版本。**Settings -> Build, Execution, Deployment -> Compiler -> Java Compiler -> Project bytecode version**。<br>
![java编译](../images/settings/javaCompiler.png)