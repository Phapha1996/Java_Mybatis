# Mybatis
这个项目事例mybatis使用懒加载，使用一级缓存，二级缓存等功能
懒加载：需要sql子查询来实现

缓存：mybatis默认缓存是PerpetualCache，可以查看一下它的源码，发现其是Cache接口的实现；那么我们的缓存只要实现该接口即可。