package com.dmcq.contentcenter.web.content;

import com.dmcq.contentcenter.domain.dto.share.ShareDTO;
import com.dmcq.contentcenter.domain.entity.share.Share;
import com.dmcq.contentcenter.service.content.ShareService;
import com.qinpiyi.common.controller.QueryController;
import com.qinpiyi.common.response.CommonResponse;
import com.qinpiyi.common.response.CommonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/share")
public class ShareController extends QueryController<Share> {

    @Autowired
    private ShareService shareService;

    @GetMapping("/{id}")
    public CommonResponse findById(@PathVariable Long id){
        return CommonResponseUtil.success(shareService.findById(id));
    }
}
