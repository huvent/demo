package com.huxp.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Huxp
 * @Since: 2018/8/27 上午11:45
 */
@Entity
@Table(name = "sys_user")
public class User {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户名
     */
    private String userNameEn;


    /**
     * 密码
     */
    private String password;


    /**
     * 密码盐
     */
    private String salt;


    /**
     * 密码是否已修改
     */
    private Boolean passwordAmended;


    /**
     * 设置/重置默认密码的时间
     */
    private Long passwordTimestamp;

    /**
     * 国际电话区号
     */
    private String callingCode;


    /**
     * 用户语言
     */
    private String locale;


    /**
     * 用户时区
     */
    private String timeZoneId;


    /**
     * 邮箱
     */
    private String email;


    /**
     * 手机号
     */
    private String mobile;


    /**
     * 出生日期
     */
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;


    /**
     * 入职日期
     */
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date entryDate;


    /**
     * 所属机构ID
     */
    private String deptId;


    /**
     * 部门名称
     */
    private String deptName;


    /**
     * 所属矿厂
     */
    private String tenantId;

    /**
     * 所属矿厂名称
     */
    private String tenantName;

    /**
     * 权限级别
     */
    private Integer userLevel;


    @JsonIgnoreProperties(value = {"users"})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "sys_user_role_rel", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles = new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getPasswordAmended() {
        return passwordAmended;
    }

    public void setPasswordAmended(Boolean passwordAmended) {
        this.passwordAmended = passwordAmended;
    }

    public Long getPasswordTimestamp() {
        return passwordTimestamp;
    }

    public void setPasswordTimestamp(Long passwordTimestamp) {
        this.passwordTimestamp = passwordTimestamp;
    }

    public String getCallingCode() {
        return callingCode;
    }

    public void setCallingCode(String callingCode) {
        this.callingCode = callingCode;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserNameEn() {
        return userNameEn;
    }

    public void setUserNameEn(String userNameEn) {
        this.userNameEn = userNameEn;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }
}
