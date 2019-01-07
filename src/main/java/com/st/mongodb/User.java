package com.st.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/7 0007 上午 10:27
 * @Version 1.0
 **/
@Document(collection = "user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;

    private String age;
}
