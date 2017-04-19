####EhCache Effective Caching: How-To
##Recipe 4 (Web Fragment Caching Web片段缓存)

In this recipe you will be shown how web fragment caching works and how EhCache make this task very simple to implement in your own Java web project. EhCache web component provides built-in helpers that can be reused in any typical web application. 
在这个配方中，您将看到Web片段缓存如何工作，以及EhCache如何使此任务在您自己的Java Web项目中实现非常简单。EhCache Web组件提供内置的助手，可以在任何典型的Web应用程序中重用。

In our case, we will create our own custom filters based on the EhCache built-in caching filters with extended criteria. The purpose of these filters is to show how customizable fragment caching is. This filter will then be integrated in Struts 2 framework application.    
在我们的例子中，我们将根据EhCache内置的具有扩展标准的缓存过滤器创建自己的自定义过滤器。这些过滤器的目的是显示如何自定义片段缓存。然后，此过滤器将集成到Struts 2框架应用程序中。

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
3. Name the configuration "Recipe 4"
4. Base directory [Browse Workspace… -> Recipe1] ${workspace_loc:/recipe4}
5. Goals: exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe4_eclipse.png) 