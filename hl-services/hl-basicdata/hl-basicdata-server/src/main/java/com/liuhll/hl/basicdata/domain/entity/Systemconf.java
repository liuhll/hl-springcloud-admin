package com.liuhll.hl.basicdata.domain.entity;

import com.liuhll.hl.common.core.domain.auditing.FullAuditedEntity;
import javax.persistence.*;

@Table(name = "`bd_systemconf`")
public class Systemconf extends FullAuditedEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 配置名称
     */
    @Column(name = "`ConfigName`")
    private String configname;

    /**
     * 配置值
     */
    @Column(name = "`ConfigValue`")
    private String configvalue;

    /**
     * 备注
     */
    @Column(name = "`Memo`")
    private String memo;

    /**
     * 序号
     */
    @Column(name = "`Seq`")
    private Integer seq;

    /**
     * 获取主键
     *
     * @return Id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取配置名称
     *
     * @return ConfigName - 配置名称
     */
    public String getConfigname() {
        return configname;
    }

    /**
     * 设置配置名称
     *
     * @param configname 配置名称
     */
    public void setConfigname(String configname) {
        this.configname = configname == null ? null : configname.trim();
    }

    /**
     * 获取配置值
     *
     * @return ConfigValue - 配置值
     */
    public String getConfigvalue() {
        return configvalue;
    }

    /**
     * 设置配置值
     *
     * @param configvalue 配置值
     */
    public void setConfigvalue(String configvalue) {
        this.configvalue = configvalue == null ? null : configvalue.trim();
    }

    /**
     * 获取备注
     *
     * @return Memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取序号
     *
     * @return Seq - 序号
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置序号
     *
     * @param seq 序号
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}