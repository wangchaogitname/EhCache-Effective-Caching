####EhCache Effective Caching: How-To
##Recipe 8 (Out-Of-Process Distributed Caching 进程外分布式缓存)

In this recipe you will be shown how to setup a RESTful Cache Server for distributed caching. EhCache provides a server module that allows developers to easily create a distributed cache architecture. 
在此recipe中，您将会看到如何为分布式缓存设置RESTful缓存服务器。
EhCache提供了一个服务器模块，允许开发人员轻松创建分布式缓存架构。

######Errata: [http://www.danielwind.net](http://www.danielwind.net/effcaching/errata)


Build Dependencies
-------

| Requirement      |  Version   |
|------------------|:----------:|
|  Apache Maven    |    3.x     |
|  Java JDK        |    >= 6    |
|  Eclipse         | >= Helios  |


Building The Recipe
-------
```
1. Import the project [File -> Import -> Maven -> Existing Maven Projects]
2. Create run configuration [Run -> Run Configurations… -> Maven Build -> New]
3. Name the configuration "Recipe 8"
4. Base directory [Browse Workspace… -> Recipe1] ${workspace_loc:/recipe8}
5. Goals: antrun:run exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe8_eclipse.png) 