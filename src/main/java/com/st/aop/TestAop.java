package com.st.aop;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestAop
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/4 0004 上午 9:20
 * @Version 1.0
 **/
@Component
@Data
public class TestAop {
    private String name;
    private String age;

    public AopDTO testAop(String name, String age) {
        System.out.println("目标方法-testAop");
        AopDTO aopDTO = new AopDTO();
        aopDTO.setName("目标方法-testAop");
        int i = 1 / 0;
        aopDTO.setAge("目标方法-testAop");
        return aopDTO;
    }
}
