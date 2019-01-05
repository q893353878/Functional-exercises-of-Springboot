package com.st;

import com.st.configuration.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkProjectApplicationTests {
    @Autowired
    Company company;

    @Test
    public void contextLoads() {
        System.out.println(company);
    }

}

