
![Licence](https://img.shields.io/badge/licence-none-green.svg)
## 简介
Spring Boot Demo 是一个基于Spring Boot & MyBatis的种子项目，用于快速构建中小型项目。
## 特性&提供
- 集成SpringFox-Swagger2，自动生成swagger注释 
- 统一响应结果封装及生成工具

- 统一异常处理
- 常用基础方法抽象(service层、dao层)封装
- 使用Druid Spring Boot Starter 集成Druid数据库连接池与监控
- 使用FastJsonHttpMessageConverter，提高JSON序列化速度
- 集成MyBatis、PageHelper分页插件
- 提供代码生成器根据表名生成对应的Domain(领域对象)、Mapper、MapperXML、Service、Controller等基础代码
- 没有集成mybatis generator，全部使用freemarker模板生成，模板随便改
- 代码生成提供Mysql、Sqlserver、Oracle三种数据库支持
- 提供了简易的代码生成配置页面，随意改包名、路径

## 快速上手
1. 克隆项目
2. 修改/src/main/resources下application-dev.properties的数据库连接、修改maven依赖的驱动，修改/src/test/resources下generator.properties的一些生成配置
3. 启动/src/test/java下面的GeneratorApplication类，访问http://localhost:8000
3. 配置自己想要生成的表名类名等信息，点击生成按钮
4. 启动/src/main/java下面的Application类
5. 访问http://localhost:8080/swagger-ui.html

## License
无，感谢各位大神的分享，感谢开源精神。