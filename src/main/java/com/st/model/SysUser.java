package com.st.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;



/**
 * @ClassName SysUser
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/4 0004 下午 5:42
 * @Version 1.0
 **/
@Table(name = "sys_user")
@Data
@ApiModel(value = "系统用户")
@Alias(value = "SysUser")
public class SysUser implements Serializable {

    @ApiModelProperty(value = "唯一标识")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Integer sysId;

    @ApiModelProperty(value = "系统用户名")
    @Column(name = "sys_name")
    private String sysName;

    @ApiModelProperty(value = "用户性别")
    @Column(name = "sys_sex")
    private String sysSex;

    @ApiModelProperty(value = "系统用户年龄")
    @Column(name = "sys_age")
    private Integer sysAge;
}
