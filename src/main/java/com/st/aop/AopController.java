package com.st.aop;

import com.st.kit.Retkit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AopController
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/4 0004 上午 11:10
 * @Version 1.0
 **/
@RestController
public class AopController {
    @RequestMapping("/company/aop")
    public Retkit<AopDTO> aop() {
        AopDTO aopDTO = new AopDTO();
        aopDTO.setAge("Aop-Controller");
        aopDTO.setName("Aop-Controller");
        Retkit<AopDTO> ret = Retkit.ok();
        return ret.data(aopDTO);
    }

    @RequestMapping("/company/aop/no")
    public Retkit noAop() {
        return Retkit.fail().message("没有权限");
    }

    @AopAnnotation(value = "aop1")
    @RequestMapping(value = "/company/aop/1")
    public Retkit aop1() {
        return Retkit.ok();
    }

    @AopAnnotation(value = "aop2")
    @RequestMapping(value = "/company/aop/2")
    public Retkit aop2() {
        return Retkit.ok();
    }
}
