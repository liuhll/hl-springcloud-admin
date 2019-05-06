package com.liuhll.hl.auth.domain.entity;

import com.liuhll.hl.auth.domain.models.UserLocked;
import com.liuhll.hl.auth.typehandler.UserLockedTypeHandler;
import com.liuhll.hl.common.core.domain.auditing.FullAuditedEntity;
import com.liuhll.hl.common.core.domain.models.Status;
import com.liuhll.hl.common.core.typehandler.StatusTypeHandler;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;

@Table(name = "`auth_user`")
public class UserInfo extends FullAuditedEntity {

    public UserInfo(){
        this.status = Status.Invalid;
        this.locked = UserLocked.UnLocked;
        this.loginFailCount = 0;
    }

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
    private Long employeeId;

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
    private String userName;

    /**
     * 密码
     */
    @Column(name = "`Password`")
    private String password;

    @Column(name = "`Locked`")
    @ColumnType(jdbcType = JdbcType.INTEGER,typeHandler = UserLockedTypeHandler.class)
    private UserLocked locked;

    @Column(name = "`LoginFailCount`")
    private Integer loginFailCount;

    /**
     * 状态
     */
    @Column(name = "`Status`")
    @ColumnType(jdbcType = JdbcType.INTEGER,typeHandler = StatusTypeHandler.class)
    private Status status;

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
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工Id
     *
     * @param employeeId 员工Id
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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

    public UserLocked getLocked() {
        return locked;
    }

    public void setLocked(UserLocked locked) {
        this.locked = locked;
    }


    public Integer getLoginFailCount() {
        return loginFailCount;
    }

    public void setLoginFailCount(Integer loginFailCount) {
        this.loginFailCount = loginFailCount;
    }
}
