package com.dmcq.usercenter.dao.bonus;

import com.dmcq.usercenter.domain.entity.bonus.BonusEventLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface BonusEventLogMapper extends Mapper<BonusEventLog> {
}