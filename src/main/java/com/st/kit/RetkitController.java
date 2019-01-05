package com.st.kit;

import com.st.configuration.Company;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RetkitController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/3 0003 下午 1:35
 * @Version 1.0
 **/
@RestController
public class RetkitController {
    @Autowired
    private Company company;

    @GetMapping(value = "/exception/ret/test")
    public Retkit<Company> testRet(){
        Company companyRet = new Company();
        BeanUtils.copyProperties(this.company,companyRet);
        return Retkit.ok(companyRet);
    }
}
