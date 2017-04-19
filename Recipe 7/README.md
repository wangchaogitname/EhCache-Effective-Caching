####EhCache Effective Caching: How-To
##Recipe 7 (Custom Eviction Algorithm 自定义排除算法)

In this recipe you will be shown how to create and implement an EhCache custom eviction algorithm. Eviction algorithms are used to determine when to evict (or simply "eject") an element from the Cache Layer. There are built-in algorithms already in EhCache that you can certainly reuse, namely:
在这个recipe中，您将会看到如何创建和实现一个EhCache自定义排除算法。
排除算法用于确定何时从缓存层中排除（或简单地“弹出”）元素。
EhCache中已经有内置算法，您可以重用，即：

- LRU (Least Recently Used, this is the default 最近使用的最少，这是默认值)
- LFU (Least Frequently Used 最少使用)
- FIFO (First In First Out 先进先出)

However, you can create your custom eviction policy by inheriting simple EhCache Abstraction classes. In our case, we will be creating our own policy for evicting elements.
但是，您可以通过继承简单的EhCache抽象类来创建自定义排除策略。
在我们这个例子中，我们将制定自己的排除要素政策。

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
3. Name the configuration "Recipe 7"
4. Base directory [Browse Workspace… -> Recipe1] ${workspace_loc:/recipe7}
5. Goals: exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe7_eclipse.png) 