# the output path is not specified for module
Cannot start compilation: the output path is not specified for module "模块名".<br>
Specify the output path in the Project Structure dialog.
## 原因
git上传文件时没有将配置文件一起上传
## 解决
1. File -> Project Structure -> Modules -> Paths -> Compiler output选择 Inherit project compile output path
2. File -> Project Structure -> Project -> Project compiler output设置 output路径。例如 "Project路径\output"