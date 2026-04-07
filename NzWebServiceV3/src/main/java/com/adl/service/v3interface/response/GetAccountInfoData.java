package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public final class GetAccountInfoData {
    /** 账号ID编码 */
    @SerializedName("id")
    private String id;

    /** 租户id */
    @SerializedName("tenantId")
    private String tenantId;

    /** 租户代码 */
    @SerializedName("tenantCode")
    private String tenantCode;

    /** 前台机构id */
    @SerializedName("orgId")
    private String orgId;

    /** 账号名 */
    @SerializedName("accountName")
    private String accountName;

    /** 所属用户id */
    @SerializedName("userId")
    private String userId;

    /** 头像 可以存储相对和绝对路径，建议相对路径 */
    @SerializedName("accountAvatar")
    private String accountAvatar;

    /** 账户账号 */
    @SerializedName("accountNum")
    private String accountNum;

    /** 账户密码 */
    @SerializedName("accountPassword")
    private String accountPassword;

    /** 账户手机号 */
    @SerializedName("accountPhoneNum")
    private String accountPhoneNum;

    /** 学号 */
    @SerializedName("studentNum")
    private String studentNum;

    /** 工号 */
    @SerializedName("jobNum")
    private String jobNum;

    /** 卡号 */
    @SerializedName("cardNum")
    private String cardNum;

    /** 部门信息 */
    @SerializedName("departmentCodes")
    private String departmentCodes;

    /** 入学年份 */
    @SerializedName("enterYear")
    private String enterYear;

    /** 注册场所id */
    @SerializedName("registerPlaceId")
    private String registerPlaceId;

    /** 注册场所名称 */
    @SerializedName("registerPlaceName")
    private String registerPlaceName;

    /** 注册appCode */
    @SerializedName("registerAppCode")
    private String registerAppCode;

    /** 注册设备id */
    @SerializedName("registerDeviceId")
    private String registerDeviceId;

    /** 注册设备sn */
    @SerializedName("registerDeviceSn")
    private String registerDeviceSn;

    /** 创建者账号 */
    @SerializedName("creatorNum")
    private String creatorNum;

    /** 头像标识 */
    @SerializedName("avatarFlag")
    private boolean avatarFlag;

    /** 记录标识 */
    @SerializedName("recordFlag")
    private boolean recordFlag;

    /** 是否启用 */
    @SerializedName("enabled")
    private boolean enabled;

    /** 删除标识位 0 可用 1 删除 */
    @SerializedName("delFlag")
    private boolean delFlag;

    /** 创建时间 */
    @SerializedName("createTime")
    private String createTime;

    /** 更新时间 */
    @SerializedName("updateTime")
    private String updateTime;

    /** 拼音全称 */
    @SerializedName("accountNamePinYin")
    private String accountNamePinYin;

    /** 首字母拼音 */
    @SerializedName("firstLetterPinYin")
    private String firstLetterPinYin;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("roleType")
    private int roleType;

    @SerializedName("orgType")
    private int orgType;

    /** 业务平台-公众用户表 */
    @SerializedName("user")
    private Object user;

    /** 人脸Base64数据 */
    @SerializedName("faceBase64")
    private String faceBase64;

    /** 人脸特征值 */
    @SerializedName("userFaces")
    private List<Object> userFaces;

    /** 用户ID编码 */
    @SerializedName("id")
    private String id;

    /** 租户id */
    @SerializedName("tenantId")
    private String tenantId;

    /** 用户姓名 */
    @SerializedName("userName")
    private String userName;

    /** 用户邮箱 */
    @SerializedName("email")
    private String email;

    /** 手机号 只能是手机号，非联系电话 */
    @SerializedName("phoneNum")
    private String phoneNum;

    /** 性别 参考字典编码：adl_tis_user_sex（1 男 2 女 9 未知） */
    @SerializedName("sex")
    private int sex;

    /** 民族代码 */
    @SerializedName("nationCode")
    private String nationCode;

    /** 人像图片地址 人像图片地址，相对路径，用于人脸检测 */
    @SerializedName("faceImgUrl")
    private String faceImgUrl;

    /** 证件类型 参考字典编码：adl_bms_cert_type（1. 身份证） */
    @SerializedName("certType")
    private int certType;

    /** 证件号 */
    @SerializedName("certNum")
    private String certNum;

    /** 学籍号 */
    @SerializedName("studentCode")
    private String studentCode;

    /** 用户生日 */
    @SerializedName("birthday")
    private String birthday;

    /** 用户地址 */
    @SerializedName("address")
    private String address;

    /** 删除标识位 0 可用 1 删除 */
    @SerializedName("delFlag")
    private boolean delFlag;

    /** 创建时间 */
    @SerializedName("createTime")
    private String createTime;

    /** 更新时间 */
    @SerializedName("updateTime")
    private String updateTime;

    @SerializedName("departments")
    private List<Object> departments;

    @SerializedName("classes")
    private List<Object> classes;

    @SerializedName("roles")
    private List<Object> roles;

    @SerializedName("accountAccountRels")
    private List<Object> accountAccountRels;

    @SerializedName("minAppPermission")
    private Object minAppPermission;

    /** 运动会权限标识位 1 开启 0 关闭 */
    @SerializedName("sportMeetFlag")
    private int sportMeetFlag;

    @SerializedName("acayearSemCode")
    private String acayearSemCode;

    @SerializedName("studentCode")
    private String studentCode;

    @SerializedName("faceImgUrl")
    private String faceImgUrl;

    @SerializedName("classId")
    private String classId;

    @SerializedName("sex")
    private int sex;

    public String getId() { return id; }
    public String getTenantId() { return tenantId; }
    public String getTenantCode() { return tenantCode; }
    public String getOrgId() { return orgId; }
    public String getAccountName() { return accountName; }
    public String getUserId() { return userId; }
    public String getAccountAvatar() { return accountAvatar; }
    public String getAccountNum() { return accountNum; }
    public String getAccountPassword() { return accountPassword; }
    public String getAccountPhoneNum() { return accountPhoneNum; }
    public String getStudentNum() { return studentNum; }
    public String getJobNum() { return jobNum; }
    public String getCardNum() { return cardNum; }
    public String getDepartmentCodes() { return departmentCodes; }
    public String getEnterYear() { return enterYear; }
    public String getRegisterPlaceId() { return registerPlaceId; }
    public String getRegisterPlaceName() { return registerPlaceName; }
    public String getRegisterAppCode() { return registerAppCode; }
    public String getRegisterDeviceId() { return registerDeviceId; }
    public String getRegisterDeviceSn() { return registerDeviceSn; }
    public String getCreatorNum() { return creatorNum; }
    public boolean getAvatarFlag() { return avatarFlag; }
    public boolean getRecordFlag() { return recordFlag; }
    public boolean getEnabled() { return enabled; }
    public boolean getDelFlag() { return delFlag; }
    public String getCreateTime() { return createTime; }
    public String getUpdateTime() { return updateTime; }
    public String getAccountNamePinYin() { return accountNamePinYin; }
    public String getFirstLetterPinYin() { return firstLetterPinYin; }
    public String getAccountId() { return accountId; }
    public int getRoleType() { return roleType; }
    public int getOrgType() { return orgType; }
    public Object getUser() { return user; }
    public String getFaceBase64() { return faceBase64; }
    public List<Object> getUserFaces() { return userFaces; }
    public String getId() { return id; }
    public String getTenantId() { return tenantId; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public String getPhoneNum() { return phoneNum; }
    public int getSex() { return sex; }
    public String getNationCode() { return nationCode; }
    public String getFaceImgUrl() { return faceImgUrl; }
    public int getCertType() { return certType; }
    public String getCertNum() { return certNum; }
    public String getStudentCode() { return studentCode; }
    public String getBirthday() { return birthday; }
    public String getAddress() { return address; }
    public boolean getDelFlag() { return delFlag; }
    public String getCreateTime() { return createTime; }
    public String getUpdateTime() { return updateTime; }
    public List<Object> getDepartments() { return departments; }
    public List<Object> getClasses() { return classes; }
    public List<Object> getRoles() { return roles; }
    public List<Object> getAccountAccountRels() { return accountAccountRels; }
    public Object getMinAppPermission() { return minAppPermission; }
    public int getSportMeetFlag() { return sportMeetFlag; }
    public String getAcayearSemCode() { return acayearSemCode; }
    public String getStudentCode() { return studentCode; }
    public String getFaceImgUrl() { return faceImgUrl; }
    public String getClassId() { return classId; }
    public int getSex() { return sex; }
}