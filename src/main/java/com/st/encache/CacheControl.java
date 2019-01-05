package com.st.encache;

import com.st.kit.Retkit;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CacheControl
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/5 0005 下午 4:16
 * @Version 1.0
 **/
@RestController
@Api
public class CacheControl {
    @Autowired
    private CacheService cacheService;

    @GetMapping(value = "/company/cache/{id}")
    public Retkit getCache(@PathVariable String id){
        return Retkit.ok().data(cacheService.getCache(id));
    }

    @GetMapping(value = "/company/cachePut/{id}")
    public Retkit cachePUT(@PathVariable String id){
        return Retkit.ok().data(cacheService.cachePut(id));
    }

    @GetMapping(value = "/company/cacheEvict/{id}")
    public Retkit cacheEvict(@PathVariable String id){
        return Retkit.ok().data(cacheService.cacheEvict(id));
    }
}
