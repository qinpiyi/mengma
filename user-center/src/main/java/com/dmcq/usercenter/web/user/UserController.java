package com.dmcq.usercenter.web.user;

import com.dmcq.usercenter.dao.user.UserMapper;
import com.dmcq.usercenter.domain.entity.user.User;
import com.dmcq.usercenter.service.user.IUserService;
import com.dmcq.usercenter.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        log.info("是我是我。。。。。。");
        User user = userService.findById(id);
        return user;
    }
}
