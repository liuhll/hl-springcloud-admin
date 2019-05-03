package com.liuhll.hl.auth.domain.entity;

import com.liuhll.hl.common.core.domain.auditing.FullAuditedEntity;
import com.liuhll.hl.common.core.domain.models.Status;
import com.liuhll.hl.common.core.typehandler.StatusTypeHandler;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;

@Table(name = "`auth_service_component`")
public class ServiceComponent extends FullAuditedEntity {

    public ServiceComponent(){
        this.status = Status.Valid;
    }

    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 服务id
     */
    @Column(name = "`ServiceId`")
    private String serviceid;

    /**
     * 名称
     */
    @Column(name = "`Name`")
    private String name;

    /**
     * 服务密钥
     */
    @Column(name = "`Secret`")
    private String secret;

    /**
     * 状态
     */
    @Column(name = "`Status`")
    @ColumnType(jdbcType = JdbcType.INTEGER,typeHandler = StatusTypeHandler.class)
    private Status status;

    /**
     * 备注
     */
    @Column(name = "`Memo`")
    private String memo;

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
     * 获取服务id
     *
     * @return ServiceId - 服务id
     */
    public String getServiceid() {
        return serviceid;
    }

    /**
     * 设置服务id
     *
     * @param serviceid 服务id
     */
    public void setServiceid(String serviceid) {
        this.serviceid = serviceid == null ? null : serviceid.trim();
    }

    /**
     * 获取名称
     *
     * @return Name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取服务密钥
     *
     * @return Secret - 服务密钥
     */
    public String getSecret() {
        return secret;
    }

    /**
     * 设置服务密钥
     *
     * @param secret 服务密钥
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * 获取状态
     *
     * @return Status - 状态
     */
    public Status getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Status status) {
        this.status = status;
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
}
