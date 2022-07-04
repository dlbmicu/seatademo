package com.example.common.user.mapper;

import com.example.common.user.entity.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhouhao
 * @date 2022/7/4
 */
@Mapper
public interface UserMapper {
    String returnSql="id";
    String  resultSql="#{id}";
    @Insert("insert into user("+returnSql+") values("+resultSql+")")
    int insert(UserDO user);
}
