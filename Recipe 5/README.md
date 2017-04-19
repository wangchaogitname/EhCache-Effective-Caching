####EhCache Effective Caching: How-To
##Recipe 5 (Hibernate Second-Level Caching 二级缓存)

In this recipe you will be shown how to integrate EhCache in a Hibernate application as a Second Level Caching solution. Second-level caching is that one associated to the Sesion Factory Object. This simply means that caching can be shared accross multiple sessions instead of a per-session basis (First-level caching).
在这个配方中，您将会看到如何将Hibernate应用程序中的EhCache集成为二级缓存解决方案。第二级缓存是与Sesion Factory对象相关联的缓存。这只是意味着缓存可以跨多个会话而不是每个会话共享（一级缓存）。

In our simple application, we will use Hibernate with embedded HSQLDB. We will exemplify how to configure EhCache as well as Hibernate to bind them together. Simplicity is used for academic purposes. Nevertheless, the same approach should be followed for complex enterprise applications.        
在我们的简单应用中，我们将使用Hibernate嵌入式HSQLDB。我们将举例说明如何将EhCache以及Hibernate配置在一起。简单性用于学术目的。然而，复杂的企业应用程序应该遵循同样的方法。

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
2. Create a run configuration [Run -> Run Configurations… -> Maven Build -> New]
3. Name the configuration "Recipe 5"
4. Base directory [Browse Workspace… -> Recipe1] ${workspace_loc:/recipe5}
5. Goals: exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe5_eclipse.png) 