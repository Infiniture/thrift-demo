# thrift-demo
> A thrift demo realized by Java.

**说明：**

- 通过打标签将`thrift-demo`不同的实现方式区分开来。
- v1.x是普通的`Java Maven`项目。
- v2.x将`thrift-demo`拆分成三个子项目，`thrift-server`, `thrift-client`是`SpringBoot`项目，`thrift-api`是普通maven项目，通过通过maven打包成jar包的形式被其它项目调用。

---

#### v1.x

**几点说明：**

- 添加依赖

  ```xml
  <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>1.7.25</version>
  </dependency>
  ```

  若不添加，则会报错误：`SLF4J:Failed to load class “org.slf4j.impl.StaticLoggerBinder”`

  详情请看：[detail](https://blog.csdn.net/u010696630/article/details/84991116)

- 先启动`Server`再启动`Client`就可以运行，然后看到结果。

---

#### V2.x

**几点说明：**

- 调用说明：

  分别启动`thrift-server`, `thrift-client`后，在浏览器地址栏输入`http://localhost:8888/infiniture/thrift`，即可看到结果。

