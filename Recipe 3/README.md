####EhCache Effective Caching: How-To
##Recipe 3 (Spring Cache Abstraction)

In this recipe you will be shown how to use built-in EhCache support in recent cache abstraction API in Spring 3.1 and higher. We will be using an annotation-based approach but will follow the traditional EhCache XML configuration. 
在此配方中，将介绍如何在Spring 3.1及更高版本中使用内置的EhCache支持。我们将使用基于注解的方法，但将遵循传统的EhCache XML配置。

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
3. Name the configuration "Recipe 3"
4. Base directory [Browse Workspace… -> Recipe3] ${workspace_loc:/recipe3}
5. Goals: jetty:run
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe3_eclipse.png)    
