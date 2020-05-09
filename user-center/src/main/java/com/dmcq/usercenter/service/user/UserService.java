package com.dmcq.usercenter.service.user;

import com.dmcq.usercenter.dao.user.UserMapper;
import com.dmcq.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: qinhao25
 * @time: 2020/1/13 9:45
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private UserMapper userMapper;

    public User findById(Long id){
        return this.userMapper.selectByPrimaryKey(id);
    }
}
