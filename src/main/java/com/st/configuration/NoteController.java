package com.st.configuration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lst
 * @date 2019年1月3日09:23:19
 *
 *@requestMapping("/login")
 * 　　　　public void login(@requestBody String userName,@requestBody String pwd){
 * 　　　　　　System.out.println(userName+" ："+pwd);
 * 　　　　}
 */
@RestController
public class NoteController {

    @PostMapping("/company/test")
    public String CompanyInfo(@RequestBody String name) {
        return name;
    }
}
