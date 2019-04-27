package com.liuhll.hl.auth.domain.entity;

import com.liuhll.hl.common.domain.auditing.AuditedEntity;
import javax.persistence.*;

@Table(name = "auth_usergroup_role")
public class rUsergroupRole extends AuditedEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    @Column(name = "UserGroupId")
    private Long usergroupid;

    @Column(name = "RoleId")
    private Long roleid;

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
     * @return UserGroupId
     */
    public Long getUsergroupid() {
        return usergroupid;
    }

    /**
     * @param usergroupid
     */
    public void setUsergroupid(Long usergroupid) {
        this.usergroupid = usergroupid;
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
}