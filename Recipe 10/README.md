####EhCache Effective Caching: How-To
##Recipe 10 (EhCache Transactional Support 事务支持)

In this recipe you will be shown how EhCache transactional support is configured and deployed in local mode. This is a Spring-based application that embeds Jetty container, Spring AOP, and JDBC - HSQLDB.
在此配方中，将显示如何在本地模式下配置和部署EhCache事务支持。这是一个嵌入Jetty容器，Spring AOP和JDBC - HSQLDB的基于Spring的应用程序。

This is a simple payroll program that shows how failed payroll transactions are rolled back so that the cached balance is equals to that in database. Worth mentioning that local transactions apply directly in Cache layer, therefore resources (database) can get out of synchronization so we need to react to that event. 
这是一个简单的工资单程序，显示失败的工资核算交易是如何回滚的，以便缓存的余额与数据库中的相等。值得一提的是，本地事务直接应用于缓存层，因此资源（数据库）可能会失去同步，因此我们需要对该事件作出反应。       

** Note: We are using local transactional mode because we have no JTA implementation. If your application supports full JTA API please consider extended architecure options (xa or xa_strict). Examples can be found here:
[http://ehcache.org/documentation/apis/transactions#Sample-Apps](http://ehcache.org/documentation/apis/transactions#Sample-Apps) 
**注意：我们正在使用本地事务模式，因为我们没有执行JTA。
如果您的应用程序支持完整的JTA API，请考虑扩展架构选项（xa或xa_strict）。
示例可以在这里找到：http : //ehcache.org/documentation/apis/transactions#Sample-Apps

#####Errata: [http://www.danielwind.net](http://www.danielwind.net/effcaching/errata)

