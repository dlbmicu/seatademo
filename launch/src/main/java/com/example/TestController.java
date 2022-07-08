package com.example;

import com.example.common.config.DynamicDataSource;
import com.example.common.user.entity.UserDO;
import com.example.common.user.mapper.UserMapper;
import io.seata.spring.annotation.GlobalTransactional;
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
    @GlobalTransactional
    public Object test(){
        insertFirst();
        return "test";
    }

    @GlobalTransactional
    public void insertFirst() {
        insertSecond();
        String old = DynamicDataSource.getDataSource();
        try{
            DynamicDataSource.setDataSource("first");
            userMapper.insert(new UserDO());
            throw new RuntimeException();
        } finally {
            DynamicDataSource.setDataSource(old);
        }
    }

    @GlobalTransactional
    public void insertSecond() {
        String old = DynamicDataSource.getDataSource();
        try{
            DynamicDataSource.setDataSource("second");
            userMapper.insert(new UserDO());
        } finally {
            DynamicDataSource.setDataSource(old);
        }
    }
}
