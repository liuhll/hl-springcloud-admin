package com.liuhll.hl.auth.domain.entity;

import com.liuhll.hl.common.core.domain.auditing.FullAuditedEntity;

import javax.persistence.*;

@Table(name = "`auth_function`")
public class Function extends FullAuditedEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 编码
     */
    @Column(name = "`Code`")
    private String code;

    /**
     * 名称
     */
    @Column(name = "`Name`")
    private String name;

    /**
     * webapi
     */
    @Column(name = "`WebApi`")
    private Integer webapi;

    /**
     * 状态
     */
    @Column(name = "`Status`")
    private Integer status;

    /**
     * 请求方法
     */
    @Column(name = "`Method`")
    private Integer method;

    /**
     * 父Id
     */
    @Column(name = "`ParentId`")
    private Long parentid;

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
     * 获取编码
     *
     * @return Code - 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编码
     *
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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
     * 获取webapi
     *
     * @return WebApi - webapi
     */
    public Integer getWebapi() {
        return webapi;
    }

    /**
     * 设置webapi
     *
     * @param webapi webapi
     */
    public void setWebapi(Integer webapi) {
        this.webapi = webapi;
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

    /**
     * 获取请求方法
     *
     * @return Method - 请求方法
     */
    public Integer getMethod() {
        return method;
    }

    /**
     * 设置请求方法
     *
     * @param method 请求方法
     */
    public void setMethod(Integer method) {
        this.method = method;
    }

    /**
     * 获取父Id
     *
     * @return ParentId - 父Id
     */
    public Long getParentid() {
        return parentid;
    }

    /**
     * 设置父Id
     *
     * @param parentid 父Id
     */
    public void setParentid(Long parentid) {
        this.parentid = parentid;
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
