package com.liuhll.hl.auth.domain.entity;

import com.liuhll.hl.common.core.domain.auditing.AuditedEntity;
import javax.persistence.*;

@Table(name = "`auth_user_group`")
public class UserGroup extends AuditedEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 父用户组Id
     */
    @Column(name = "`ParentId`")
    private String parentId;

    /**
     * 用户组名称
     */
    @Column(name = "`GroupName`")
    private String groupName;

    /**
     * 状态
     */
    @Column(name = "`Status`")
    private Integer status;

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
     * 获取父用户组Id
     *
     * @return ParentId - 父用户组Id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父用户组Id
     *
     * @param parentId 父用户组Id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取用户组名称
     *
     * @return GroupName - 用户组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置用户组名称
     *
     * @param groupName 用户组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 获取状态
     *
     * @return Status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}