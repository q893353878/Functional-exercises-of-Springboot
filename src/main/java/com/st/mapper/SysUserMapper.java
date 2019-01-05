package com.st.mapper;

import com.st.kit.MyMapper;
import com.st.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * @author admin
 */
@Mapper
@Component
public interface SysUserMapper extends MyMapper<SysUser> {
    List<SysUser> listUserById(String id);
}
