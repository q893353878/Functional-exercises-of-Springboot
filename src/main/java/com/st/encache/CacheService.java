package com.st.encache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName CacheService
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/5 0005 下午 4:17
 * @Version 1.0
 **/
@Service
@CacheConfig(cacheNames = "ehcache_company")
public class CacheService {
    /**
     * 先查询缓存，查不到，执行方法，再将结果缓存
     * condition 方法调用前评估
     * unless 方法调用后评估，满足条件不缓存,youxianji gao
     */
    @Cacheable(key = "#id", condition = "#id.equals('1')||#id.equals('2')",unless = "#id.equals('2')")
    public String getCache(String id){
        System.out.println("getCache");
        return id;
    }

    /**
     * @param id
     * @return
     * 删除缓存
     */
    @CacheEvict(key = "#id")
    public String cacheEvict(String id){
        System.out.println("cacheEvict");
        return id + "删除";
    }

    /**
     * @param id
     * @return
     * 插入或者更新缓存
     */
    @CachePut(key = "#id")
    public String cachePut(String id){
        System.out.println("cachePut");
        return id + "cachePut";
    }
}
