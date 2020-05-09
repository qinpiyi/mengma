package com.dmcq.contentcenter.sentinel.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dmcq.contentcenter.domain.dto.share.ShareDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: qinhao25
 * @time: 2020/1/20 15:50
 */
@Slf4j
public class ShareServiceBlockHandler {

    /**
     * 处理限流或者降级
     * @param id
     * @param e
     * @return
     */
    public static ShareDTO findByIdBlockHandler(Long id,BlockException e){
        log.warn("限流或降级了",e);
        return null;
    }
}
