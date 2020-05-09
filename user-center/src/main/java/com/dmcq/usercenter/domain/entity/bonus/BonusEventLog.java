package com.dmcq.usercenter.domain.entity.bonus;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "bonus_event_log")
public class BonusEventLog {
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * user.id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 积分操作值
     */
    private Integer value;

    /**
     * 发生的事件
     */
    private String event;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 描述
     */
    private String description;
}