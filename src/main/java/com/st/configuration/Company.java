package com.st.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
*
* @auther:lst
 * @date: 2019年1月2日17:19:50
 *
*
* */
@Data
@Configuration // cglib 代理
@ConfigurationProperties(prefix = "company")
@Validated
public class Company implements Serializable {
    private String name;
    private String from;
    private Integer level;
    private List<Info> info;
    private Website website;
    private Map<String, String> treasure;
    @Data
    private static class Info {
        private String location;
        private String nature;
        private String city;
    }
    @Data
    private static class Website {
        private String url;
        private String manager;
        private Integer password;
    }
}
