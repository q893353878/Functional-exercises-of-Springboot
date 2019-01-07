package com.st.mongodb;

import com.st.kit.Retkit;
import com.st.mongodb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/7 0007 上午 10:27
 * @Version 1.0
 **/
@RestController
@Api
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "测试 swagger")
    @GetMapping(value = "/company/user/{id}")
    public Retkit<User> getUserById(@PathVariable String id){
        Retkit<User> ok = Retkit.ok();
        return ok.data(userService.getUserById(id));
    }

    @ApiIgnore
    @GetMapping(value = "/company/user/name/{name}")
    public Retkit<User> getUserByName(@PathVariable String name){
        Retkit<User> ok = Retkit.ok();
        return ok.data(userService.getUserByName(name));
    }
    @GetMapping(value = "/jail/user/form/{name}")
    public Retkit<User> getUserFromName(@PathVariable String name){
        Retkit<User> ok = Retkit.ok();
        return ok.data(userService.findFromName(name));
    }
}
