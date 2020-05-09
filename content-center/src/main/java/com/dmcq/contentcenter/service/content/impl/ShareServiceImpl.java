package com.dmcq.contentcenter.service.content.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dmcq.contentcenter.domain.dto.share.ShareDTO;
import com.dmcq.contentcenter.domain.dto.user.UserDTO;
import com.dmcq.contentcenter.domain.entity.share.Share;
import com.dmcq.contentcenter.feign.UserCenterApi;
import com.dmcq.contentcenter.mapper.share.ShareMapper;
import com.dmcq.contentcenter.sentinel.block.ShareServiceBlockHandler;
import com.dmcq.contentcenter.sentinel.fallback.ShareServiceFallbackHandler;
import com.dmcq.contentcenter.service.content.ShareService;
import com.qinpiyi.common.service.QueryServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: qinhao25
 * @time: 2020/1/13 11:22
 */
@Service
public class ShareServiceImpl extends QueryServiceImpl<Share> implements ShareService {

    @Autowired
    private ShareMapper shareMapper ;

    @Autowired
    private UserCenterApi userCenterApi;

    //@SentinelResource(
    //        value = "findShareDTOById",
    //        blockHandlerClass = ShareServiceBlockHandler.class,
    //        blockHandler = "findByIdBlockHandler",
    //        fallbackClass = ShareServiceFallbackHandler.class,
    //        fallback = "findByIdFallback"
    //)
    @Override
    public ShareDTO findById(Long id) {
        if(id == null){
            throw new IllegalArgumentException("id cannot be null.");
        }
        //获取分享详情
        Share share = shareMapper.selectByPrimaryKey(id);
        if(share == null){
            return null;
        }
        Long userId = share.getUserId();
        //获取发布人信息
        UserDTO userDTO = userCenterApi.findById(userId);
        //数据装配
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share,shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }
}
