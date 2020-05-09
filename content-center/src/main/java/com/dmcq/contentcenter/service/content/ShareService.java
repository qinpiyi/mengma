package com.dmcq.contentcenter.service.content;

import com.dmcq.contentcenter.domain.dto.share.ShareDTO;
import com.dmcq.contentcenter.domain.entity.share.Share;
import com.qinpiyi.common.service.QueryService;

public interface ShareService extends QueryService<Share> {
    ShareDTO findById(Long id);
}
