package com.st.exception;

import com.st.kit.Retkit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ExceptionController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/3 0003 上午 11:30
 * @Version 1.0
 **/
@RestController
public class ExceptionController {

    @GetMapping("/company/exception/test")
    public Retkit exceptionTest(){
        int i = 1/0;
        return Retkit.ok();
    }

}
