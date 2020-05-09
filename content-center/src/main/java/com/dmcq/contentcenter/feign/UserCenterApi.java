package com.dmcq.contentcenter.feign;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dmcq.contentcenter.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-center")
public interface UserCenterApi {

    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id);
}
