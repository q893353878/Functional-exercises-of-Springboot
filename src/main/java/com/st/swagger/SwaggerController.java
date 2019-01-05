package com.st.swagger;

import com.st.common.Groups;
import com.st.kit.Retkit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SwaggerController
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/4 0004 下午 4:49
 * @Version 1.0
 **/
@RestController
@Api
@Validated
public class SwaggerController {
    /**
     * jQuery.ajax ({
     * url: myurl,
     * type: "POST",
     * data: JSON.stringify({data:"test"}),
     * dataType: "json",
     * contentType: "application/json;charset=utf-8",
     * success: function(){
     * //
     * }
     * });
     */
    @PostMapping(value = "/company/swagger")
    public Retkit<Swagger> test(@Validated(value = {Groups.Update.class}) @RequestBody Swagger swagger) {
        return Retkit.ok(swagger);
    }

    @GetMapping(value = "/company/swagger/bean")
    public Retkit<Swagger> testBean(@Validated(value = {Groups.Insert.class}) Swagger swagger) {
        return Retkit.ok(swagger);
    }

    @GetMapping(value = "/company/swagger/{id}")
    @ApiOperation(value = "ceshiRestful", notes = "参数在URL中", httpMethod = "GET")
    public Retkit<String> testPathVariable(@PathVariable String id) {
        return Retkit.ok(id);
    }

    @PostMapping(value = "/company/swagger/param")
    @ApiOperation(value = "测试表单", notes = "参数为lists=111&lists=2222或者lists=124124,13213", httpMethod = "POST")
    public Retkit<List<String>>  testParamPost(@RequestParam List<String> lists, String name)
    {
        return Retkit.ok(lists);
    }
}
