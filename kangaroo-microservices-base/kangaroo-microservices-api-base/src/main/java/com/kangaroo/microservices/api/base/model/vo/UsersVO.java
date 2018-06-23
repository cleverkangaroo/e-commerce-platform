package com.kangaroo.microservices.api.base.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
public class UsersVO implements Serializable{
   
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private Long id;

	    private String dtype;


	    private Boolean isenabled;

	    private Boolean islocked;


	    private Date lockdate;

	    private String department;

	    private String email;

	    private String encodedpassword;

	    private String mobile;

	    private String name;

	    private String username;

	    private BigDecimal balance;

	 

	

	    private String phone;

	    private Date safekeyexpire;

	    private String safekeyvalue;

	    private String taximage;

	    private String address;

	    private BigDecimal amount;

	    private Date birth;

	    /**
	     * 性别 0：男、1：女
	     */
	    private Byte gender;


	    private Long areaId;

	    private Long memberrankId;

	    private String miniopenid;

	    private String nickname;

	    private String avatar;

	    private Byte channelid;

	    /**
	     * 小程序名称
	     */
	    private String appname;

	    /**
	     * 用户是否合法，通过网易易盾接口来校验，NULL值表示未校验，0表示非法，1表示合法
	     */
	    private Boolean legel;

	    private Boolean issubscribe;

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

	public Boolean getIsenabled() {
		return isenabled;
	}

	public void setIsenabled(Boolean isenabled) {
		this.isenabled = isenabled;
	}

	public Boolean getIslocked() {
		return islocked;
	}

	public void setIslocked(Boolean islocked) {
		this.islocked = islocked;
	}

	public Date getLockdate() {
		return lockdate;
	}

	public void setLockdate(Date lockdate) {
		this.lockdate = lockdate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncodedpassword() {
		return encodedpassword;
	}

	public void setEncodedpassword(String encodedpassword) {
		this.encodedpassword = encodedpassword;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getSafekeyexpire() {
		return safekeyexpire;
	}

	public void setSafekeyexpire(Date safekeyexpire) {
		this.safekeyexpire = safekeyexpire;
	}

	public String getSafekeyvalue() {
		return safekeyvalue;
	}

	public void setSafekeyvalue(String safekeyvalue) {
		this.safekeyvalue = safekeyvalue;
	}

	public String getTaximage() {
		return taximage;
	}

	public void setTaximage(String taximage) {
		this.taximage = taximage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getMemberrankId() {
		return memberrankId;
	}

	public void setMemberrankId(Long memberrankId) {
		this.memberrankId = memberrankId;
	}

	public String getMiniopenid() {
		return miniopenid;
	}

	public void setMiniopenid(String miniopenid) {
		this.miniopenid = miniopenid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Byte getChannelid() {
		return channelid;
	}

	public void setChannelid(Byte channelid) {
		this.channelid = channelid;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public Boolean getLegel() {
		return legel;
	}

	public void setLegel(Boolean legel) {
		this.legel = legel;
	}

	public Boolean getIssubscribe() {
		return issubscribe;
	}

	public void setIssubscribe(Boolean issubscribe) {
		this.issubscribe = issubscribe;
	}

	public String getServicewechat() {
		return servicewechat;
	}

	public void setServicewechat(String servicewechat) {
		this.servicewechat = servicewechat;
	}

 
   
}