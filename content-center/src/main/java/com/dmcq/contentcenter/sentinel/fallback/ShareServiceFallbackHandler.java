package com.dmcq.contentcenter.sentinel.fallback;

import com.dmcq.contentcenter.domain.dto.share.ShareDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: qinhao25
 * @time: 2020/1/20 15:50
 */
@Slf4j
public class ShareServiceFallbackHandler {

    /**
     * 1.5处理降级
     * 1.6处理异常
     * @param id
     * @return
     */
    public static ShareDTO findByIdFallback(Long id,Throwable t){
        log.warn("发生了降级或异常",t);
        return null;
    }
}
