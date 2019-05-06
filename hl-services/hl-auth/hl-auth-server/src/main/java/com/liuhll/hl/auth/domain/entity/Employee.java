package com.liuhll.hl.auth.domain.entity;

import com.liuhll.hl.auth.domain.models.Gender;
import com.liuhll.hl.auth.domain.models.PoliticalStatus;
import com.liuhll.hl.auth.typehandler.GenderTypeHandler;
import com.liuhll.hl.auth.typehandler.PoliticalStatusTypeHandler;
import com.liuhll.hl.common.core.domain.auditing.FullAuditedEntity;
import com.liuhll.hl.common.core.domain.models.Status;
import com.liuhll.hl.common.core.typehandler.StatusTypeHandler;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`auth_employee`")
public class Employee extends FullAuditedEntity {

    public Employee(){
        this.status = Status.Invalid;
    }

    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "`UserName`")
    private String userName;

    /**
     * 中文名
     */
    @Column(name = "`ChineseName`")
    private String chineseName;

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
     * 性别
     */
    @Column(name = "`Gender`")
    @ColumnType(jdbcType = JdbcType.INTEGER,typeHandler = GenderTypeHandler.class)
    private Gender gender;

    /**
     * 生日
     */
    @Column(name = "`Birth`")
    private Date birth;

    /**
     * 籍贯
     */
    @Column(name = "`NativePlace`")
    private String nativePlace;

    /**
     * 住址
     */
    @Column(name = "`Address`")
    private String address;

    /**
     * 民族
     */
    @Column(name = "`Folk`")
    private String folk;

    /**
     * 政治面貌
     */
    @Column(name = "`PoliticalStatus`")
    @ColumnType(jdbcType = JdbcType.INTEGER,typeHandler = PoliticalStatusTypeHandler.class)
    private PoliticalStatus politicalStatus;

    /**
     * 毕业院校
     */
    @Column(name = "`GraduateInstitutions`")
    private String graduateInstitutions;

    /**
     * 学历
     */
    @Column(name = "`Education`")
    private String education;

    /**
     * 专业
     */
    @Column(name = "`Major`")
    private String major;

    /**
     * 简历
     */
    @Column(name = "`Resume`")
    private String resume;

    /**
     * 备注
     */
    @Column(name = "`Memo`")
    private String memo;

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
     * 获取中文名
     *
     * @return ChineseName - 中文名
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * 设置中文名
     *
     * @param chineseName 中文名
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
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
     * 获取性别
     *
     * @return Gender - 性别
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * 获取生日
     *
     * @return Birth - 生日
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置生日
     *
     * @param birth 生日
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 获取籍贯
     *
     * @return NativePlace - 籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 设置籍贯
     *
     * @param nativePlace 籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    /**
     * 获取住址
     *
     * @return Address - 住址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置住址
     *
     * @param address 住址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取民族
     *
     * @return Folk - 民族
     */
    public String getFolk() {
        return folk;
    }

    /**
     * 设置民族
     *
     * @param folk 民族
     */
    public void setFolk(String folk) {
        this.folk = folk == null ? null : folk.trim();
    }

    /**
     * 获取政治面貌
     *
     * @return PoliticalStatus - 政治面貌
     */
    public PoliticalStatus getPoliticalStatus() {
        return politicalStatus;
    }

    /**
     * 设置政治面貌
     *
     * @param politicalStatus 政治面貌
     */
    public void setPoliticalStatus(PoliticalStatus politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    /**
     * 获取毕业院校
     *
     * @return GraduateInstitutions - 毕业院校
     */
    public String getGraduateInstitutions() {
        return graduateInstitutions;
    }

    /**
     * 设置毕业院校
     *
     * @param graduateInstitutions 毕业院校
     */
    public void setGraduateInstitutions(String graduateInstitutions) {
        this.graduateInstitutions = graduateInstitutions == null ? null : graduateInstitutions.trim();
    }

    /**
     * 获取学历
     *
     * @return Education - 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /**
     * 获取专业
     *
     * @return Major - 专业
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置专业
     *
     * @param major 专业
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * 获取简历
     *
     * @return Resume - 简历
     */
    public String getResume() {
        return resume;
    }

    /**
     * 设置简历
     *
     * @param resume 简历
     */
    public void setResume(String resume) {
        this.resume = resume == null ? null : resume.trim();
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
}
