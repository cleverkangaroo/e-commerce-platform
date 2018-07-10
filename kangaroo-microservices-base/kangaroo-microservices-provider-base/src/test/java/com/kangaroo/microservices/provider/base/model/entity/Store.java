package com.kangaroo.microservices.provider.base.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`Store`")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdDate")
    private Date createddate;

    @Column(name = "lastModifiedDate")
    private Date lastmodifieddate;

    private Long version;

    private String address;

    @Column(name = "bailPaid")
    private BigDecimal bailpaid;

    @Column(name = "discountPromotionEndDate")
    private Date discountpromotionenddate;

    private String email;

    @Column(name = "endDate")
    private Date enddate;

    @Column(name = "fullReductionPromotionEndDate")
    private Date fullreductionpromotionenddate;

    private String introduction;

    @Column(name = "isEnabled")
    private Boolean isenabled;

    private String keyword;

    private String logo;

    private String mobile;

    private String name;

    private String phone;

    private Byte status;

    private Byte type;

    @Column(name = "zipCode")
    private String zipcode;

    @Column(name = "business_id")
    private Long businessId;

    @Column(name = "storeCategory_id")
    private Long storecategoryId;

    @Column(name = "storeRank_id")
    private Long storerankId;

    @Column(name = "groupPromotionEndDate")
    private Date grouppromotionenddate;

    @Column(name = "stockWarn")
    private Integer stockwarn;

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
    public Long getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
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
     * @return bailPaid
     */
    public BigDecimal getBailpaid() {
        return bailpaid;
    }

    /**
     * @param bailpaid
     */
    public void setBailpaid(BigDecimal bailpaid) {
        this.bailpaid = bailpaid;
    }

    /**
     * @return discountPromotionEndDate
     */
    public Date getDiscountpromotionenddate() {
        return discountpromotionenddate;
    }

    /**
     * @param discountpromotionenddate
     */
    public void setDiscountpromotionenddate(Date discountpromotionenddate) {
        this.discountpromotionenddate = discountpromotionenddate;
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
     * @return endDate
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * @param enddate
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * @return fullReductionPromotionEndDate
     */
    public Date getFullreductionpromotionenddate() {
        return fullreductionpromotionenddate;
    }

    /**
     * @param fullreductionpromotionenddate
     */
    public void setFullreductionpromotionenddate(Date fullreductionpromotionenddate) {
        this.fullreductionpromotionenddate = fullreductionpromotionenddate;
    }

    /**
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
     * @return keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
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
     * @return status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @return type
     */
    public Byte getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Byte type) {
        this.type = type;
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
     * @return business_id
     */
    public Long getBusinessId() {
        return businessId;
    }

    /**
     * @param businessId
     */
    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    /**
     * @return storeCategory_id
     */
    public Long getStorecategoryId() {
        return storecategoryId;
    }

    /**
     * @param storecategoryId
     */
    public void setStorecategoryId(Long storecategoryId) {
        this.storecategoryId = storecategoryId;
    }

    /**
     * @return storeRank_id
     */
    public Long getStorerankId() {
        return storerankId;
    }

    /**
     * @param storerankId
     */
    public void setStorerankId(Long storerankId) {
        this.storerankId = storerankId;
    }

    /**
     * @return groupPromotionEndDate
     */
    public Date getGrouppromotionenddate() {
        return grouppromotionenddate;
    }

    /**
     * @param grouppromotionenddate
     */
    public void setGrouppromotionenddate(Date grouppromotionenddate) {
        this.grouppromotionenddate = grouppromotionenddate;
    }

    /**
     * @return stockWarn
     */
    public Integer getStockwarn() {
        return stockwarn;
    }

    /**
     * @param stockwarn
     */
    public void setStockwarn(Integer stockwarn) {
        this.stockwarn = stockwarn;
    }
}