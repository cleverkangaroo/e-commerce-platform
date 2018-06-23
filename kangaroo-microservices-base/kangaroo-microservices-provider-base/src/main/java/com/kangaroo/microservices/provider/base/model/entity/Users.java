package com.kangaroo.microservices.provider.base.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
@Table(name = "`Users`")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dtype;

    @Column(name = "createdDate")
    private Date createddate;

    @Column(name = "lastModifiedDate")
    private Date lastmodifieddate;

    private Short version;

    @Column(name = "isEnabled")
    private Boolean isenabled;

    @Column(name = "isLocked")
    private Boolean islocked;

    @Column(name = "lastLoginDate")
    private Date lastlogindate;

    @Column(name = "lastLoginIp")
    private String lastloginip;

    @Column(name = "lockDate")
    private Date lockdate;

    private String department;

    private String email;

    @Column(name = "encodedPassword")
    private String encodedpassword;

    private String mobile;

    private String name;

    private String username;

    @Column(name = "attributeValue0")
    private String attributevalue0;

    @Column(name = "attributeValue1")
    private String attributevalue1;

    @Column(name = "attributeValue10")
    private String attributevalue10;

    @Column(name = "attributeValue11")
    private String attributevalue11;

    @Column(name = "attributeValue12")
    private String attributevalue12;

    @Column(name = "attributeValue13")
    private String attributevalue13;

    @Column(name = "attributeValue14")
    private String attributevalue14;

    @Column(name = "attributeValue15")
    private String attributevalue15;

    @Column(name = "attributeValue16")
    private String attributevalue16;

    @Column(name = "attributeValue17")
    private String attributevalue17;

    @Column(name = "attributeValue18")
    private String attributevalue18;

    @Column(name = "attributeValue19")
    private String attributevalue19;

    @Column(name = "attributeValue2")
    private String attributevalue2;

    @Column(name = "attributeValue3")
    private String attributevalue3;

    @Column(name = "attributeValue4")
    private String attributevalue4;

    @Column(name = "attributeValue5")
    private String attributevalue5;

    @Column(name = "attributeValue6")
    private String attributevalue6;

    @Column(name = "attributeValue7")
    private String attributevalue7;

    @Column(name = "attributeValue8")
    private String attributevalue8;

    @Column(name = "attributeValue9")
    private String attributevalue9;

    private BigDecimal balance;

    @Column(name = "bankAccount")
    private String bankaccount;

    @Column(name = "bankName")
    private String bankname;

    @Column(name = "frozenAmount")
    private BigDecimal frozenamount;

    @Column(name = "idCard")
    private String idcard;

    @Column(name = "idCardImage")
    private String idcardimage;

    @Column(name = "identificationNumber")
    private String identificationnumber;

    @Column(name = "legalPerson")
    private String legalperson;

    @Column(name = "licenseImage")
    private String licenseimage;

    @Column(name = "licenseNumber")
    private String licensenumber;

    @Column(name = "organizationCode")
    private String organizationcode;

    @Column(name = "organizationImage")
    private String organizationimage;

    private String phone;

    @Column(name = "safeKeyExpire")
    private Date safekeyexpire;

    @Column(name = "safeKeyValue")
    private String safekeyvalue;

    @Column(name = "taxImage")
    private String taximage;

    private String address;

    private BigDecimal amount;

    private Date birth;

    /**
     * 性别 0：男、1：女
     */
    private Byte gender;

    private Short point;

    @Column(name = "zipCode")
    private String zipcode;

    @Column(name = "area_id")
    private Long areaId;

    @Column(name = "memberRank_id")
    private Long memberrankId;

    @Column(name = "miniOpenId")
    private String miniopenid;

    private String nickname;

    private String avatar;

    /**
     * 渠道ID
     */
    @Column(name = "channelId")
    private Byte channelid;

    /**
     * 小程序名称
     */
    @Column(name = "appName")
    private String appname;

    /**
     * 用户是否合法，通过网易易盾接口来校验，NULL值表示未校验，0表示非法，1表示合法
     */
    private Boolean legel;

    @Column(name = "isSubscribe")
    private Boolean issubscribe;

    @Column(name = "serviceWechat")
    private String servicewechat;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return dtype
     */
    public String getDtype() {
        return dtype;
    }

    /**
     * @param dtype
     */
    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    /**
     * @return createdDate
     */
    public Date getCreateddate() {
        return createddate;
    }

    /**
     * @param createddate
     */
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    /**
     * @return lastModifiedDate
     */
    public Date getLastmodifieddate() {
        return lastmodifieddate;
    }

    /**
     * @param lastmodifieddate
     */
    public void setLastmodifieddate(Date lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    /**
     * @return version
     */
    public Short getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Short version) {
        this.version = version;
    }

    /**
     * @return isEnabled
     */
    public Boolean getIsenabled() {
        return isenabled;
    }

    /**
     * @param isenabled
     */
    public void setIsenabled(Boolean isenabled) {
        this.isenabled = isenabled;
    }

    /**
     * @return isLocked
     */
    public Boolean getIslocked() {
        return islocked;
    }

    /**
     * @param islocked
     */
    public void setIslocked(Boolean islocked) {
        this.islocked = islocked;
    }

    /**
     * @return lastLoginDate
     */
    public Date getLastlogindate() {
        return lastlogindate;
    }

    /**
     * @param lastlogindate
     */
    public void setLastlogindate(Date lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    /**
     * @return lastLoginIp
     */
    public String getLastloginip() {
        return lastloginip;
    }

    /**
     * @param lastloginip
     */
    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

    /**
     * @return lockDate
     */
    public Date getLockdate() {
        return lockdate;
    }

    /**
     * @param lockdate
     */
    public void setLockdate(Date lockdate) {
        this.lockdate = lockdate;
    }

    /**
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return encodedPassword
     */
    public String getEncodedpassword() {
        return encodedpassword;
    }

    /**
     * @param encodedpassword
     */
    public void setEncodedpassword(String encodedpassword) {
        this.encodedpassword = encodedpassword;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return attributeValue0
     */
    public String getAttributevalue0() {
        return attributevalue0;
    }

    /**
     * @param attributevalue0
     */
    public void setAttributevalue0(String attributevalue0) {
        this.attributevalue0 = attributevalue0;
    }

    /**
     * @return attributeValue1
     */
    public String getAttributevalue1() {
        return attributevalue1;
    }

    /**
     * @param attributevalue1
     */
    public void setAttributevalue1(String attributevalue1) {
        this.attributevalue1 = attributevalue1;
    }

    /**
     * @return attributeValue10
     */
    public String getAttributevalue10() {
        return attributevalue10;
    }

    /**
     * @param attributevalue10
     */
    public void setAttributevalue10(String attributevalue10) {
        this.attributevalue10 = attributevalue10;
    }

    /**
     * @return attributeValue11
     */
    public String getAttributevalue11() {
        return attributevalue11;
    }

    /**
     * @param attributevalue11
     */
    public void setAttributevalue11(String attributevalue11) {
        this.attributevalue11 = attributevalue11;
    }

    /**
     * @return attributeValue12
     */
    public String getAttributevalue12() {
        return attributevalue12;
    }

    /**
     * @param attributevalue12
     */
    public void setAttributevalue12(String attributevalue12) {
        this.attributevalue12 = attributevalue12;
    }

    /**
     * @return attributeValue13
     */
    public String getAttributevalue13() {
        return attributevalue13;
    }

    /**
     * @param attributevalue13
     */
    public void setAttributevalue13(String attributevalue13) {
        this.attributevalue13 = attributevalue13;
    }

    /**
     * @return attributeValue14
     */
    public String getAttributevalue14() {
        return attributevalue14;
    }

    /**
     * @param attributevalue14
     */
    public void setAttributevalue14(String attributevalue14) {
        this.attributevalue14 = attributevalue14;
    }

    /**
     * @return attributeValue15
     */
    public String getAttributevalue15() {
        return attributevalue15;
    }

    /**
     * @param attributevalue15
     */
    public void setAttributevalue15(String attributevalue15) {
        this.attributevalue15 = attributevalue15;
    }

    /**
     * @return attributeValue16
     */
    public String getAttributevalue16() {
        return attributevalue16;
    }

    /**
     * @param attributevalue16
     */
    public void setAttributevalue16(String attributevalue16) {
        this.attributevalue16 = attributevalue16;
    }

    /**
     * @return attributeValue17
     */
    public String getAttributevalue17() {
        return attributevalue17;
    }

    /**
     * @param attributevalue17
     */
    public void setAttributevalue17(String attributevalue17) {
        this.attributevalue17 = attributevalue17;
    }

    /**
     * @return attributeValue18
     */
    public String getAttributevalue18() {
        return attributevalue18;
    }

    /**
     * @param attributevalue18
     */
    public void setAttributevalue18(String attributevalue18) {
        this.attributevalue18 = attributevalue18;
    }

    /**
     * @return attributeValue19
     */
    public String getAttributevalue19() {
        return attributevalue19;
    }

    /**
     * @param attributevalue19
     */
    public void setAttributevalue19(String attributevalue19) {
        this.attributevalue19 = attributevalue19;
    }

    /**
     * @return attributeValue2
     */
    public String getAttributevalue2() {
        return attributevalue2;
    }

    /**
     * @param attributevalue2
     */
    public void setAttributevalue2(String attributevalue2) {
        this.attributevalue2 = attributevalue2;
    }

    /**
     * @return attributeValue3
     */
    public String getAttributevalue3() {
        return attributevalue3;
    }

    /**
     * @param attributevalue3
     */
    public void setAttributevalue3(String attributevalue3) {
        this.attributevalue3 = attributevalue3;
    }

    /**
     * @return attributeValue4
     */
    public String getAttributevalue4() {
        return attributevalue4;
    }

    /**
     * @param attributevalue4
     */
    public void setAttributevalue4(String attributevalue4) {
        this.attributevalue4 = attributevalue4;
    }

    /**
     * @return attributeValue5
     */
    public String getAttributevalue5() {
        return attributevalue5;
    }

    /**
     * @param attributevalue5
     */
    public void setAttributevalue5(String attributevalue5) {
        this.attributevalue5 = attributevalue5;
    }

    /**
     * @return attributeValue6
     */
    public String getAttributevalue6() {
        return attributevalue6;
    }

    /**
     * @param attributevalue6
     */
    public void setAttributevalue6(String attributevalue6) {
        this.attributevalue6 = attributevalue6;
    }

    /**
     * @return attributeValue7
     */
    public String getAttributevalue7() {
        return attributevalue7;
    }

    /**
     * @param attributevalue7
     */
    public void setAttributevalue7(String attributevalue7) {
        this.attributevalue7 = attributevalue7;
    }

    /**
     * @return attributeValue8
     */
    public String getAttributevalue8() {
        return attributevalue8;
    }

    /**
     * @param attributevalue8
     */
    public void setAttributevalue8(String attributevalue8) {
        this.attributevalue8 = attributevalue8;
    }

    /**
     * @return attributeValue9
     */
    public String getAttributevalue9() {
        return attributevalue9;
    }

    /**
     * @param attributevalue9
     */
    public void setAttributevalue9(String attributevalue9) {
        this.attributevalue9 = attributevalue9;
    }

    /**
     * @return balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * @return bankAccount
     */
    public String getBankaccount() {
        return bankaccount;
    }

    /**
     * @param bankaccount
     */
    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    /**
     * @return bankName
     */
    public String getBankname() {
        return bankname;
    }

    /**
     * @param bankname
     */
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    /**
     * @return frozenAmount
     */
    public BigDecimal getFrozenamount() {
        return frozenamount;
    }

    /**
     * @param frozenamount
     */
    public void setFrozenamount(BigDecimal frozenamount) {
        this.frozenamount = frozenamount;
    }

    /**
     * @return idCard
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * @param idcard
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * @return idCardImage
     */
    public String getIdcardimage() {
        return idcardimage;
    }

    /**
     * @param idcardimage
     */
    public void setIdcardimage(String idcardimage) {
        this.idcardimage = idcardimage;
    }

    /**
     * @return identificationNumber
     */
    public String getIdentificationnumber() {
        return identificationnumber;
    }

    /**
     * @param identificationnumber
     */
    public void setIdentificationnumber(String identificationnumber) {
        this.identificationnumber = identificationnumber;
    }

    /**
     * @return legalPerson
     */
    public String getLegalperson() {
        return legalperson;
    }

    /**
     * @param legalperson
     */
    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson;
    }

    /**
     * @return licenseImage
     */
    public String getLicenseimage() {
        return licenseimage;
    }

    /**
     * @param licenseimage
     */
    public void setLicenseimage(String licenseimage) {
        this.licenseimage = licenseimage;
    }

    /**
     * @return licenseNumber
     */
    public String getLicensenumber() {
        return licensenumber;
    }

    /**
     * @param licensenumber
     */
    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    /**
     * @return organizationCode
     */
    public String getOrganizationcode() {
        return organizationcode;
    }

    /**
     * @param organizationcode
     */
    public void setOrganizationcode(String organizationcode) {
        this.organizationcode = organizationcode;
    }

    /**
     * @return organizationImage
     */
    public String getOrganizationimage() {
        return organizationimage;
    }

    /**
     * @param organizationimage
     */
    public void setOrganizationimage(String organizationimage) {
        this.organizationimage = organizationimage;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return safeKeyExpire
     */
    public Date getSafekeyexpire() {
        return safekeyexpire;
    }

    /**
     * @param safekeyexpire
     */
    public void setSafekeyexpire(Date safekeyexpire) {
        this.safekeyexpire = safekeyexpire;
    }

    /**
     * @return safeKeyValue
     */
    public String getSafekeyvalue() {
        return safekeyvalue;
    }

    /**
     * @param safekeyvalue
     */
    public void setSafekeyvalue(String safekeyvalue) {
        this.safekeyvalue = safekeyvalue;
    }

    /**
     * @return taxImage
     */
    public String getTaximage() {
        return taximage;
    }

    /**
     * @param taximage
     */
    public void setTaximage(String taximage) {
        this.taximage = taximage;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * @param birth
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 获取性别 0：男、1：女
     *
     * @return gender - 性别 0：男、1：女
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * 设置性别 0：男、1：女
     *
     * @param gender 性别 0：男、1：女
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * @return point
     */
    public Short getPoint() {
        return point;
    }

    /**
     * @param point
     */
    public void setPoint(Short point) {
        this.point = point;
    }

    /**
     * @return zipCode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return area_id
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
     * @return memberRank_id
     */
    public Long getMemberrankId() {
        return memberrankId;
    }

    /**
     * @param memberrankId
     */
    public void setMemberrankId(Long memberrankId) {
        this.memberrankId = memberrankId;
    }

    /**
     * @return miniOpenId
     */
    public String getMiniopenid() {
        return miniopenid;
    }

    /**
     * @param miniopenid
     */
    public void setMiniopenid(String miniopenid) {
        this.miniopenid = miniopenid;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取渠道ID
     *
     * @return channelId - 渠道ID
     */
    public Byte getChannelid() {
        return channelid;
    }

    /**
     * 设置渠道ID
     *
     * @param channelid 渠道ID
     */
    public void setChannelid(Byte channelid) {
        this.channelid = channelid;
    }

    /**
     * 获取小程序名称
     *
     * @return appName - 小程序名称
     */
    public String getAppname() {
        return appname;
    }

    /**
     * 设置小程序名称
     *
     * @param appname 小程序名称
     */
    public void setAppname(String appname) {
        this.appname = appname;
    }

    /**
     * 获取用户是否合法，通过网易易盾接口来校验，NULL值表示未校验，0表示非法，1表示合法
     *
     * @return legel - 用户是否合法，通过网易易盾接口来校验，NULL值表示未校验，0表示非法，1表示合法
     */
    public Boolean getLegel() {
        return legel;
    }

    /**
     * 设置用户是否合法，通过网易易盾接口来校验，NULL值表示未校验，0表示非法，1表示合法
     *
     * @param legel 用户是否合法，通过网易易盾接口来校验，NULL值表示未校验，0表示非法，1表示合法
     */
    public void setLegel(Boolean legel) {
        this.legel = legel;
    }

    /**
     * @return isSubscribe
     */
    public Boolean getIssubscribe() {
        return issubscribe;
    }

    /**
     * @param issubscribe
     */
    public void setIssubscribe(Boolean issubscribe) {
        this.issubscribe = issubscribe;
    }

    /**
     * @return serviceWechat
     */
    public String getServicewechat() {
        return servicewechat;
    }

    /**
     * @param servicewechat
     */
    public void setServicewechat(String servicewechat) {
        this.servicewechat = servicewechat;
    }
}