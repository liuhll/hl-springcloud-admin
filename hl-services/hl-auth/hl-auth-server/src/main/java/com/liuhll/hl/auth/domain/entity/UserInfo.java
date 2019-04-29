package com.liuhll.hl.auth.domain.entity;

import com.liuhll.hl.common.domain.auditing.FullAuditedEntity;
import javax.persistence.*;

@Table(name = "`auth_user`")
public class UserInfo extends FullAuditedEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 员工Id
     */
    @Column(name = "`EmployeeId`")
    private Long employeeid;

    /**
     * 电子邮件
     */
    @Column(name = "`Email`")
    private String email;

    /**
     * 联系电话
     */
    @Column(name = "`Phone`")
    private String phone;

    /**
     * 用户名
     */
    @Column(name = "`UserName`")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`Password`")
    private String password;

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
     * 获取员工Id
     *
     * @return EmployeeId - 员工Id
     */
    public Long getEmployeeid() {
        return employeeid;
    }

    /**
     * 设置员工Id
     *
     * @param employeeid 员工Id
     */
    public void setEmployeeid(Long employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * 获取电子邮件
     *
     * @return Email - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取联系电话
     *
     * @return Phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取用户名
     *
     * @return UserName - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return Password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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