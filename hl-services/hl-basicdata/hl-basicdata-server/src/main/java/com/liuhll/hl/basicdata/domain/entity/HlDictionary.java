package com.liuhll.hl.basicdata.domain.entity;

import com.liuhll.hl.common.core.domain.auditing.FullAuditedEntity;
import javax.persistence.*;

@Table(name = "`bd_dictionary`")
public class HlDictionary extends FullAuditedEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 唯一编码
     */
    @Column(name = "`Code`")
    private String code;

    /**
     * 字典名称
     */
    @Column(name = "`Name`")
    private String name;

    /**
     * 字典值
     */
    @Column(name = "`Value`")
    private String value;

    /**
     * 父级Id
     */
    @Column(name = "`ParentId`")
    private Long parentId;

    /**
     * 序号
     */
    @Column(name = "`Seq`")
    private Integer seq;

    /**
     * 分类名称
     */
    @Column(name = "`TypeName`")
    private String typeName;

    /**
     * 0.没有 1.有
     */
    @Column(name = "`HasChild`")
    private Integer hasChild;

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
     * 获取唯一编码
     *
     * @return Code - 唯一编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置唯一编码
     *
     * @param code 唯一编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取字典名称
     *
     * @return Name - 字典名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置字典名称
     *
     * @param name 字典名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取字典值
     *
     * @return Value - 字典值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置字典值
     *
     * @param value 字典值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 获取父级Id
     *
     * @return ParentId - 父级Id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级Id
     *
     * @param parentId 父级Id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * 获取分类名称
     *
     * @return TypeName - 分类名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置分类名称
     *
     * @param typeName 分类名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 获取0.没有 1.有
     *
     * @return HasChild - 0.没有 1.有
     */
    public Integer getHasChild() {
        return hasChild;
    }

    /**
     * 设置0.没有 1.有
     *
     * @param hasChild 0.没有 1.有
     */
    public void setHasChild(Integer hasChild) {
        this.hasChild = hasChild;
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