package com.st.mybatis;


import com.github.pagehelper.PageHelper;
import com.st.kit.Retkit;
import com.st.mapper.SysUserMapper;
import com.st.model.SysUser;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName MybatisController
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/5 0005 上午 10:58
 * @Version 1.0
 **/
@RestController
@Api
public class MybatisController {
    @Autowired
    private SysUserMapper sysUserMapper;

    @PostMapping(value = "/company/mybatis/user")
    public Retkit<SysUser> mybatisUser(@RequestBody SysUser sysUser){
        sysUserMapper.insert(sysUser);
        return Retkit.ok(sysUser);
    }

    @GetMapping(value = "/jail/mybatis/user/{id}/info")
    public List<SysUser> listSysUser(@PathVariable String id) {
        return sysUserMapper.listUserById(id);
    }

    @GetMapping(value = "/jail/mybatis/page/{pageNum}/{pageSize}")
    public List<SysUser> sysUserListPage(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return sysUserMapper.selectAll();
    }
}
