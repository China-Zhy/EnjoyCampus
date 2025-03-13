> 《基于SSM的JavaWeb项目-乐享校园》

---

**团队成员**：`张宏业、张月、黄果、马蓉、张容彬`

**项目描述**：`一款为校园生活提供便利和乐趣的APP。目前托管的是Web管理系统的主要代码。`

---

**命名规范**：`表名 + 层次名` `XxxMapper` `XxxService` `XxxController`

**页面命名规范**：`管理页面：xxxManager`

---

**代码编写顺序**：

1. 根据数据库中的数据表，在 entity包 中创建对应实体类 Xxx，创建属性，并打上注解@Data @NoArgsConstructor @AllArgsConstructor
   @ToString 等注解。
2. 根据需求，在 dao包 中写数据库层接口 XxxMapper。单独传递某个参数需要使用 @Param注解。
3. 复制接口的 完全限定名，然后在 resources 下的 Mapper文件夹中 创建 XxxMapper.xml，并在namespace中粘贴 接口的完全限定名，然后编写SQL。
4. 编写好SQL之后，在mybatis-config.xml 中的 <mappers>标签内 添加刚才创建的 XxxMapper.xml文件路径。
5. 接下来写Service层，创建XxxService接口。 然后再创建XxxServiceImpl实现类来实现接口。 实现类中要打上 @Service注解。
6. XxxServiceImpl实现类中，通过 @Autowired注解注入 XxxMapper，然后在方法内通过 xxxMapper 对象调用dao层方法。
7. 当XxxServiceImpl写好后，去创建对应的XxxTest，并继承 BaseTest，然后通过 @Test注解 进行单元测试，使用 @Autowired注解注入
   XxxService。
8. 单元测试没有问题后，在 Controller包中 创建 XxxController，并打上 @Controller 或 @RestController 以及 @RequestMapping
   等注解。
9. 创建业务的Html页面，与 Controller 层进行数据交互。局部使用Ajax进行异步请求。

---

**团队成员分工**：

*     张宏业：APP开发、用户管理、餐品管理、地址管理(收货地址管理、餐品地址管理) 根据address表中的type进行分类
*     常嘉祺：审核管理(配送员审核、餐品审核、餐厅管理员审核) 根据audit表中的type进行分类，点击entity查看详情，修改state，添加info。
*     张  月：订单管理(跑腿订单、点餐订单)
*     张长志：餐品口味管理、餐品种类管理(增删改查)
