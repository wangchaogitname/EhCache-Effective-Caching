####EhCache Effective Caching: How-To
##Recipe 6 (Cache Search API 缓存搜索API)

In this recipe you will be shown how the Cache Search API works through a simple cache search query implementation. EhCache search API allows us to query and search for elements being cached. We start by issuing simple queries and then increase complexity by relaxing query criteria conditions.
在这个recipe，您将看到缓存搜索API是如何工作的通过一个简单的缓存搜索查询的实现。的Ehcache搜索API允许我们查询和搜索被缓存的元素。我们首先通过发出简单的查询，然后通过放松查询条件的条件下增加复杂性。

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
3. Name the configuration "Recipe 6"
4. Base directory [Browse Workspace… -> Recipe1] ${workspace_loc:/recipe6}
5. Goals: exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe6_eclipse.png) 