####EhCache Effective Caching: How-To
##Recipe 12 (Datasource Read Overload)

In this recipe you will be shown how to configure and apply a simple solution to the "thundering herd" problem. This problem becomes evident when multiple concurrent clients are requesting the same cached data element. Some of those clients will then read an empty cached value therefore ask directly to the datasource about it. This causes unnecesary queries.
在这个recipe中，你将会看到如何配置和应用一个简单的解决方案来解决“惊群”问题。当多个并发客户端请求相同的缓存数据元素时，这个问题变得很明显。其中一些客户端然后将读取一个空的缓存值，因此直接向数据源询问它。这将导致不必要的查询。

In out simple scenario, we will simulate high concurrency in a single JVM that will read a single cached value. We will then compare access results enabling/disabling our solution.
在简单的情况下，我们将在单个JVM中模拟高并发性，从而读取单个缓存值。然后，我们将比较启用/禁用我们的解决方案的访问结果。

#####Errata: [http://www.danielwind.net](http://www.danielwind.net/effcaching/errata)
