# **Windows** 向 **centos** 传输文件

使用 lrzsz(Linux 服务器和 window 互传文件工具) 传输文件。

## lrzsz

`lrzsz` 是一款在 `linux` 里可代替 `ftp` 上传和下载的程序。

## 安装

```
yum -y install lrzsz
```

## 上传

* 从 `windows` 系统上传文件到 `centos` 系统。

  ```
  rz
  ```

* 在弹出的窗口中选择传输的文件

  ![open](../images/openWind.png)

  ## 下载

  * 从 `centos` 系统下载文件到 `windows` 系统。

    ```
    sz 文件名
    ```

  * 在弹出窗口中选择保存路径

    ![download](../images/downWind.png)

