package com.st.encache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName EhCacheConfig
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/5 0005 下午 4:17
 * @Version 1.0
 **/
@Configuration
@EnableCaching
public class EhCacheConfig {
    /**
     *1）@CacheConfig(cacheNames = {“lemonCache”})设置了ehcache的名称，这个名称就是ehcache.xml内的名称；
     *2）@Cacheable：应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调 用方法获取数据，然后把数据添加到缓存中，适用于查找；
     *3）@CachePut：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用。
     * 适用于更新和插入；
     *4）@CacheEvict：主要针对方法配置，能够根据一定的条件对缓存进行清空。适用于删除。
     */
}
