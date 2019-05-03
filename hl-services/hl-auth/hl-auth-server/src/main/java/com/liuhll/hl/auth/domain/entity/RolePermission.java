package com.liuhll.hl.auth.domain.entity;

import com.liuhll.hl.common.core.domain.auditing.AuditedEntity;
import javax.persistence.*;

@Table(name = "`auth_role_permission`")
public class RolePermission extends AuditedEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    @Column(name = "`RoleId`")
    private Long roleid;

    @Column(name = "`PerssionId`")
    private String perssionid;

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
     * @return RoleId
     */
    public Long getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    /**
     * @return PerssionId
     */
    public String getPerssionid() {
        return perssionid;
    }

    /**
     * @param perssionid
     */
    public void setPerssionid(String perssionid) {
        this.perssionid = perssionid == null ? null : perssionid.trim();
    }
}