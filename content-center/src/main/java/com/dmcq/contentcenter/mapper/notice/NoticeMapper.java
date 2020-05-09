package com.dmcq.contentcenter.mapper.notice;

import com.dmcq.contentcenter.domain.entity.notice.Notice;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface NoticeMapper extends Mapper<Notice> {
}