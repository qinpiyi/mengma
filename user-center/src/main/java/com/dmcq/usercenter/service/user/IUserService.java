package com.dmcq.usercenter.service.user;

import com.dmcq.usercenter.domain.entity.user.User;

public interface IUserService {

    User findById(Long id);
}
