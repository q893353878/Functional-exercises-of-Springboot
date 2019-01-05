package com.st.exception;

import com.st.kit.SpringBeanKit;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @ClassName MyErrorConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/3 0003 下午 1:52
 * @Version 1.0
 **/
@Configuration
public class MyErrorConfig {
    @Bean
    public MyBasicErrorController basicErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
        List<ErrorViewResolver> errorViewResolvers = SpringBeanKit.getBean(ErrorViewResolver.class);
        return new MyBasicErrorController(errorAttributes, serverProperties.getError(),errorViewResolvers);
    }
}
