package com.st.configuration;

import com.sun.javafx.logging.PulseLogger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lst
 * @date 2019年1月2日17:31:30
 *
 */
@RestController
public class CompanyController {
    @Autowired
    private Company company;

    @GetMapping("/company/configuration")
    public Company getConfigurationCompany(){
        Company company1 = new Company();
        BeanUtils.copyProperties(this.company,company1);
        return company1;
    }

    @GetMapping("/test01/{id}")
    public String getPathVariable(@PathVariable("id") Integer id){
        System.out.println("PathVariable : " + id);
        return "success";
    }


}
