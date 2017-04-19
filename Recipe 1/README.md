#EhCache Effective Caching: How-To

Recipe 1 (Configuration Patterns 配置模式)
-------

In this recipe you will be shown how to configure EhCache within your application. Commonly there are two ways of proceeding with the actual configuration:
在此配方中，您将会看到如何在应用程序中配置EhCache。通常有两种进行实际配置的方法：

- Programmatically (Custom Class)
- 以编程方式（自定义类）
- Declaratively (XML)
- 声明式（XML）

Our simple java application will load the typical declarative configuration through ehcache.xml (resources folder). Our custom cache class, named CacheDelegate, also shows how to configure the application and EhCache in a programatic way. 
我们简单的java应用程序将通过ehcache.xml（资源文件夹）加载典型的声明性配置。我们的自定义缓存类，名为CacheDelegate，还显示了如何以编程方式配置应用程序和EhCache。

See [CacheDelegate#programmaticConfiguration](https://github.com/danielwind/EhCache-Effective-Caching/tree/master/Recipe%201/src/main/java/net/danielwind/effcaching/recipe1/cache/CacheDelegate/#L9)

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
3. Name the configuration "Recipe 1"
4. Base directory [Browse Workspace… -> Recipe1] ${workspace_loc:/recipe1}
5. Goals: exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe1_eclipse.png)
