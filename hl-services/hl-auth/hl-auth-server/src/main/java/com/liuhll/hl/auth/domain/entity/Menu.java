package com.liuhll.hl.auth.domain.entity;

import com.liuhll.hl.common.domain.auditing.FullAuditedEntity;
import javax.persistence.*;

@Table(name = "`auth_menu`")
public class Menu extends FullAuditedEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 菜单编码
     */
    @Column(name = "`Code`")
    private String code;

    /**
     * 菜单名称
     */
    @Column(name = "`Name`")
    private String name;

    /**
     * 菜单URL
     */
    @Column(name = "`UrlPath`")
    private Integer urlpath;

    /**
     * 父Id
     */
    @Column(name = "`ParentId`")
    private Long parentid;

    /**
     * 层级
     */
    @Column(name = "`Level`")
    private Integer level;

    /**
     * 菜单类型
     */
    @Column(name = "`Mold`")
    private Integer mold;

    /**
     * icon图标
     */
    @Column(name = "`Icon`")
    private String icon;

    /**
     * 前端组件
     */
    @Column(name = "`FrontEndComponent`")
    private String frontendcomponent;

    /**
     * 排序
     */
    @Column(name = "`Sort`")
    private Integer sort;

    /**
     * 备注
     */
    @Column(name = "`Memo`")
    private String memo;

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
     * 获取菜单编码
     *
     * @return Code - 菜单编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置菜单编码
     *
     * @param code 菜单编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取菜单名称
     *
     * @return Name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取菜单URL
     *
     * @return UrlPath - 菜单URL
     */
    public Integer getUrlpath() {
        return urlpath;
    }

    /**
     * 设置菜单URL
     *
     * @param urlpath 菜单URL
     */
    public void setUrlpath(Integer urlpath) {
        this.urlpath = urlpath;
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
     * 获取层级
     *
     * @return Level - 层级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置层级
     *
     * @param level 层级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取菜单类型
     *
     * @return Mold - 菜单类型
     */
    public Integer getMold() {
        return mold;
    }

    /**
     * 设置菜单类型
     *
     * @param mold 菜单类型
     */
    public void setMold(Integer mold) {
        this.mold = mold;
    }

    /**
     * 获取icon图标
     *
     * @return Icon - icon图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置icon图标
     *
     * @param icon icon图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取前端组件
     *
     * @return FrontEndComponent - 前端组件
     */
    public String getFrontendcomponent() {
        return frontendcomponent;
    }

    /**
     * 设置前端组件
     *
     * @param frontendcomponent 前端组件
     */
    public void setFrontendcomponent(String frontendcomponent) {
        this.frontendcomponent = frontendcomponent == null ? null : frontendcomponent.trim();
    }

    /**
     * 获取排序
     *
     * @return Sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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