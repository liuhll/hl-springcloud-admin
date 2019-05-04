package com.liuhll.hl.basicdata.domain.entity;

import com.liuhll.hl.common.core.domain.auditing.FullAuditedEntity;
import javax.persistence.*;

@Table(name = "`bd_systemconf`")
public class Systemconf extends FullAuditedEntity {

    public Systemconf(){
        this.sysPreSet = 0;
    }

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
    private String configName;

    /**
     * 配置值
     */
    @Column(name = "`ConfigValue`")
    private String configValue;

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
     * 0. 否 1.是
     */
    @Column(name = "`SysPreSet`")
    private Integer sysPreSet;

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
    public String getConfigName() {
        return configName;
    }

    /**
     * 设置配置名称
     *
     * @param configName 配置名称
     */
    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    /**
     * 获取配置值
     *
     * @return ConfigValue - 配置值
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * 设置配置值
     *
     * @param configValue 配置值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
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

    /**
     * 获取0. 否 1.是
     *
     * @return SysPreSet - 0. 否 1.是
     */
    public Integer getSysPreSet() {
        return sysPreSet;
    }

    /**
     * 设置0. 否 1.是
     *
     * @param sysPreSet 0. 否 1.是
     */
    public void setSysPreSet(Integer sysPreSet) {
        this.sysPreSet = sysPreSet;
    }
}
