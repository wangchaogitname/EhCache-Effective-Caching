####EhCache Effective Caching: How-To
##Recipe 2 (Listening Events & Exceptions 监听事件和异常)

In this recipe you are shown how to react to EhCache Events and how to catch generated exceptions. EhCache Event Model is strictly defined and very extensible allowing us to customize and react accordingly. This task is crucial in production environments.
在这个配方中，您将会看到如何对EhCache Events做出反应，以及如何捕获生成的异常。
EhCache事件模型是严格定义和非常可扩展的，允许我们进行相应的自定义和反应。这个任务在生产环境中至关重要。

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
3. Name the configuration "Recipe 2"
4. Base directory [Browse Workspace… -> Recipe2] ${workspace_loc:/recipe2}
5. Goals: exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe2_eclipse.png)    