package com.liuhll.hl.auth.domain.entity;

import com.liuhll.hl.common.domain.auditing.FullAuditedEntity;
import javax.persistence.*;

@Table(name = "auth_permission")
public class Permission extends FullAuditedEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 权限编码
     */
    @Column(name = "Code")
    private String code;

    /**
     * 权限名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * 权限类型 1.菜单  2. 操作 3. 页面元素 4. 文件
     */
    @Column(name = "Mold")
    private Integer mold;

    /**
     * 备注
     */
    @Column(name = "Memo")
    private String memo;

    /**
     * 状态
     */
    @Column(name = "Status")
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
     * 获取权限编码
     *
     * @return Code - 权限编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置权限编码
     *
     * @param code 权限编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取权限名称
     *
     * @return Name - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取权限类型 1.菜单  2. 操作 3. 页面元素 4. 文件
     *
     * @return Mold - 权限类型 1.菜单  2. 操作 3. 页面元素 4. 文件
     */
    public Integer getMold() {
        return mold;
    }

    /**
     * 设置权限类型 1.菜单  2. 操作 3. 页面元素 4. 文件
     *
     * @param mold 权限类型 1.菜单  2. 操作 3. 页面元素 4. 文件
     */
    public void setMold(Integer mold) {
        this.mold = mold;
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