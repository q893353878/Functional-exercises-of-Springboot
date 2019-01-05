package com.st.swagger;

import com.st.common.Groups;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName Swagger
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/4 0004 下午 4:48
 * @Version 1.0
 **/
@Data
@ApiModel
public class Swagger {
    @ApiModelProperty(value = "主键标识", name = "id", notes = "数据库主键说明", dataType = "String", required = true, position = 1,
            hidden = false, example = "6524315")
    @NotBlank(message = "id 不能为空", groups = Groups.Insert.class)
    private String id;
    @ApiModelProperty(value = "姓名", name = "name", notes = "用户姓名", dataType = "String", required = true, position = 2,
            hidden = false, example = "渣渣辉")
    @NotBlank(message = "姓名不能为空")
    private String name;
    @ApiModelProperty(name = "sex", value = "性别", notes = "性别", dataType = "String", required = true, position = 3,
            allowableValues = "男,女", hidden = false, example = "男")
    private String sex;
    @ApiModelProperty( name = "level", value = "等级", notes = "目前所在等级", dataType = "Integer", required = true, position = 4,
            allowableValues = "range[1,5]", hidden = false,example = "1")
    private Integer level;
    @ApiModelProperty(name = "location", value = "所在地", notes = "当前所在地", dataType = "String", required = false, position = 5,
            allowableValues = "北京,深圳,上海,南京", hidden = false, example = "北京")
    private String location;
    @ApiModelProperty(name = "age", value = "年龄", notes = "年龄不能很小哦", dataType = "Integer", required = false, position = 6,
            allowableValues = "range[0,125]", hidden = false, example = "22")
    private Integer age;
    @ApiModelProperty(value = "公司", name = "company", notes = "公司", dataType = "String", required = false, position = 7,
            hidden = false, example = "微软")
    private String company;


}
