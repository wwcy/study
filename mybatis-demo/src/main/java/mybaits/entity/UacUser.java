package mybaits.entity;

/**
 * @auth wcy on 2019/7/9.
 */
//@EqualsAndHashCode(callSuper = true)
//@Data
//@Table(name = "uam_uac_user")
//@Alias(value = "uacUser")
public class UacUser extends BaseEntity{
    private static final long serialVersionUID = 5465775492730080699L;

    /**
     * 登录名
     */
    //@Column(name = "login_name")
    private String loginName;

    /**
     * 登录密码
     */
    //@Column(name = "login_pwd")
    private String loginPwd;

    /**
     * 姓名
     */
    //@Column(name = "username")
    private String username;

    /**
     * 手机号
     */
    //@Column(name = "mobile_no")
    private String mobileNo;

    //@Column(name = "email")
    private String email;

    /**
     * 最后登录IP地址
     */
    //@Column(name = "last_login_ip")
    private String lastLoginIp;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Override
    public String toString() {
        return "UacUser{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", status=" + status +
                ", loginPwd='" + loginPwd + '\'' +
                ", isSys=" + isSys +
                ", username='" + username + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", createdDate=" + createDate +
                ", email='" + email + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", updatedDate=" + updateDate +
                ", createdBy='" + createBy + '\'' +
                ", updatedBy='" + updateBy + '\'' +
                '}';
    }
}
