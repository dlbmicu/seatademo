package com.example;

import com.example.common.config.DynamicDataSource;
import com.example.common.user.entity.UserDO;
import com.example.common.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author zhouhao
 * @date 2022/7/4
 */
@RestController
public class TestController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("test")
    public Object test(){
        DynamicDataSource.setDataSource("first");
        insert();
        DynamicDataSource.setDataSource("second");
        insert();
        return "test";
    }

    public void insert() {
        userMapper.insert(new UserDO());
    }
}
