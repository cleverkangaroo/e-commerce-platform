package com.kangaroo.microservices.provider.base.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`Product`")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdDate")
    private Date createddate;

    @Column(name = "lastModifiedDate")
    private Date lastmodifieddate;

    private Integer version;

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

    private String caption;

    private BigDecimal cost;

    private Short hits;

    @Column(name = "isActive")
    private Boolean isactive;

    @Column(name = "isDelivery")
    private Boolean isdelivery;

    @Column(name = "isList")
    private Boolean islist;

    @Column(name = "isMarketable")
    private Boolean ismarketable;

    @Column(name = "isTop")
    private Boolean istop;

    private String keyword;

    @Column(name = "marketPrice")
    private BigDecimal marketprice;

    @Column(name = "maxCommission")
    private BigDecimal maxcommission;

    private String memo;

    @Column(name = "monthHits")
    private Integer monthhits;

    @Column(name = "monthHitsDate")
    private Date monthhitsdate;

    @Column(name = "monthSales")
    private Integer monthsales;

    @Column(name = "monthSalesDate")
    private Date monthsalesdate;

    private String name;

    @Column(name = "parameterValues")
    private String parametervalues;

    private BigDecimal price;

    private Short sales;

    private Float score;

    @Column(name = "scoreCount")
    private Short scorecount;

    private String sn;

    @Column(name = "specificationItems")
    private String specificationitems;

    @Column(name = "totalScore")
    private Short totalscore;

    private Integer type;

    private String unit;

    @Column(name = "weekHits")
    private Short weekhits;

    @Column(name = "weekHitsDate")
    private Date weekhitsdate;

    @Column(name = "weekSales")
    private Short weeksales;

    @Column(name = "weekSalesDate")
    private Date weeksalesdate;

    private Short weight;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "productCategory_id")
    private Long productcategoryId;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "storeProductCategory_id")
    private Long storeproductcategoryId;

    /**
     * 拼团价
     */
    @Column(name = "groupPrice")
    private BigDecimal groupprice;

    /**
     * 拼团数
     */
    @Column(name = "groupNumber")
    private Byte groupnumber;

    /**
     * 拼团销量
     */
    @Column(name = "groupSales")
    private Short groupsales;

    /**
     * 拼团规则
     */
    @Column(name = "groupRules")
    private String grouprules;

    /**
     *  商品展示顺序 数值越小越靠前 1最小
     */
    private Short sort;

    /**
     * 是否锁定，用于改价0--未锁定，1--锁定
     */
    @Column(name = "lock_status")
    private Byte lockStatus;

    /**
     * 默认的商品缩略图
     */
    private String thumbnail;

    /**
     * 0--未删除，1--删除
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

    /**
     * 是否保护，如果保护，不参加优惠计算
     */
    @Column(name = "isProtected")
    private Boolean isprotected;

    private String tag;

    /**
     * 商品标签，数据字典表的id
     */
    @Column(name = "tag_id")
    private Long tagId;

    private Integer deleted;

    private String introduction;

    @Column(name = "productImages")
    private String productimages;

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
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
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
     * @return caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * @param caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * @return cost
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * @param cost
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * @return hits
     */
    public Short getHits() {
        return hits;
    }

    /**
     * @param hits
     */
    public void setHits(Short hits) {
        this.hits = hits;
    }

    /**
     * @return isActive
     */
    public Boolean getIsactive() {
        return isactive;
    }

    /**
     * @param isactive
     */
    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    /**
     * @return isDelivery
     */
    public Boolean getIsdelivery() {
        return isdelivery;
    }

    /**
     * @param isdelivery
     */
    public void setIsdelivery(Boolean isdelivery) {
        this.isdelivery = isdelivery;
    }

    /**
     * @return isList
     */
    public Boolean getIslist() {
        return islist;
    }

    /**
     * @param islist
     */
    public void setIslist(Boolean islist) {
        this.islist = islist;
    }

    /**
     * @return isMarketable
     */
    public Boolean getIsmarketable() {
        return ismarketable;
    }

    /**
     * @param ismarketable
     */
    public void setIsmarketable(Boolean ismarketable) {
        this.ismarketable = ismarketable;
    }

    /**
     * @return isTop
     */
    public Boolean getIstop() {
        return istop;
    }

    /**
     * @param istop
     */
    public void setIstop(Boolean istop) {
        this.istop = istop;
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
     * @return marketPrice
     */
    public BigDecimal getMarketprice() {
        return marketprice;
    }

    /**
     * @param marketprice
     */
    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    /**
     * @return maxCommission
     */
    public BigDecimal getMaxcommission() {
        return maxcommission;
    }

    /**
     * @param maxcommission
     */
    public void setMaxcommission(BigDecimal maxcommission) {
        this.maxcommission = maxcommission;
    }

    /**
     * @return memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return monthHits
     */
    public Integer getMonthhits() {
        return monthhits;
    }

    /**
     * @param monthhits
     */
    public void setMonthhits(Integer monthhits) {
        this.monthhits = monthhits;
    }

    /**
     * @return monthHitsDate
     */
    public Date getMonthhitsdate() {
        return monthhitsdate;
    }

    /**
     * @param monthhitsdate
     */
    public void setMonthhitsdate(Date monthhitsdate) {
        this.monthhitsdate = monthhitsdate;
    }

    /**
     * @return monthSales
     */
    public Integer getMonthsales() {
        return monthsales;
    }

    /**
     * @param monthsales
     */
    public void setMonthsales(Integer monthsales) {
        this.monthsales = monthsales;
    }

    /**
     * @return monthSalesDate
     */
    public Date getMonthsalesdate() {
        return monthsalesdate;
    }

    /**
     * @param monthsalesdate
     */
    public void setMonthsalesdate(Date monthsalesdate) {
        this.monthsalesdate = monthsalesdate;
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
     * @return parameterValues
     */
    public String getParametervalues() {
        return parametervalues;
    }

    /**
     * @param parametervalues
     */
    public void setParametervalues(String parametervalues) {
        this.parametervalues = parametervalues;
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return sales
     */
    public Short getSales() {
        return sales;
    }

    /**
     * @param sales
     */
    public void setSales(Short sales) {
        this.sales = sales;
    }

    /**
     * @return score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * @return scoreCount
     */
    public Short getScorecount() {
        return scorecount;
    }

    /**
     * @param scorecount
     */
    public void setScorecount(Short scorecount) {
        this.scorecount = scorecount;
    }

    /**
     * @return sn
     */
    public String getSn() {
        return sn;
    }

    /**
     * @param sn
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * @return specificationItems
     */
    public String getSpecificationitems() {
        return specificationitems;
    }

    /**
     * @param specificationitems
     */
    public void setSpecificationitems(String specificationitems) {
        this.specificationitems = specificationitems;
    }

    /**
     * @return totalScore
     */
    public Short getTotalscore() {
        return totalscore;
    }

    /**
     * @param totalscore
     */
    public void setTotalscore(Short totalscore) {
        this.totalscore = totalscore;
    }

    /**
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return weekHits
     */
    public Short getWeekhits() {
        return weekhits;
    }

    /**
     * @param weekhits
     */
    public void setWeekhits(Short weekhits) {
        this.weekhits = weekhits;
    }

    /**
     * @return weekHitsDate
     */
    public Date getWeekhitsdate() {
        return weekhitsdate;
    }

    /**
     * @param weekhitsdate
     */
    public void setWeekhitsdate(Date weekhitsdate) {
        this.weekhitsdate = weekhitsdate;
    }

    /**
     * @return weekSales
     */
    public Short getWeeksales() {
        return weeksales;
    }

    /**
     * @param weeksales
     */
    public void setWeeksales(Short weeksales) {
        this.weeksales = weeksales;
    }

    /**
     * @return weekSalesDate
     */
    public Date getWeeksalesdate() {
        return weeksalesdate;
    }

    /**
     * @param weeksalesdate
     */
    public void setWeeksalesdate(Date weeksalesdate) {
        this.weeksalesdate = weeksalesdate;
    }

    /**
     * @return weight
     */
    public Short getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(Short weight) {
        this.weight = weight;
    }

    /**
     * @return brand_id
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * @param brandId
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * @return productCategory_id
     */
    public Long getProductcategoryId() {
        return productcategoryId;
    }

    /**
     * @param productcategoryId
     */
    public void setProductcategoryId(Long productcategoryId) {
        this.productcategoryId = productcategoryId;
    }

    /**
     * @return store_id
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * @param storeId
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * @return storeProductCategory_id
     */
    public Long getStoreproductcategoryId() {
        return storeproductcategoryId;
    }

    /**
     * @param storeproductcategoryId
     */
    public void setStoreproductcategoryId(Long storeproductcategoryId) {
        this.storeproductcategoryId = storeproductcategoryId;
    }

    /**
     * 获取拼团价
     *
     * @return groupPrice - 拼团价
     */
    public BigDecimal getGroupprice() {
        return groupprice;
    }

    /**
     * 设置拼团价
     *
     * @param groupprice 拼团价
     */
    public void setGroupprice(BigDecimal groupprice) {
        this.groupprice = groupprice;
    }

    /**
     * 获取拼团数
     *
     * @return groupNumber - 拼团数
     */
    public Byte getGroupnumber() {
        return groupnumber;
    }

    /**
     * 设置拼团数
     *
     * @param groupnumber 拼团数
     */
    public void setGroupnumber(Byte groupnumber) {
        this.groupnumber = groupnumber;
    }

    /**
     * 获取拼团销量
     *
     * @return groupSales - 拼团销量
     */
    public Short getGroupsales() {
        return groupsales;
    }

    /**
     * 设置拼团销量
     *
     * @param groupsales 拼团销量
     */
    public void setGroupsales(Short groupsales) {
        this.groupsales = groupsales;
    }

    /**
     * 获取拼团规则
     *
     * @return groupRules - 拼团规则
     */
    public String getGrouprules() {
        return grouprules;
    }

    /**
     * 设置拼团规则
     *
     * @param grouprules 拼团规则
     */
    public void setGrouprules(String grouprules) {
        this.grouprules = grouprules;
    }

    /**
     * 获取 商品展示顺序 数值越小越靠前 1最小
     *
     * @return sort -  商品展示顺序 数值越小越靠前 1最小
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置 商品展示顺序 数值越小越靠前 1最小
     *
     * @param sort  商品展示顺序 数值越小越靠前 1最小
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * 获取是否锁定，用于改价0--未锁定，1--锁定
     *
     * @return lock_status - 是否锁定，用于改价0--未锁定，1--锁定
     */
    public Byte getLockStatus() {
        return lockStatus;
    }

    /**
     * 设置是否锁定，用于改价0--未锁定，1--锁定
     *
     * @param lockStatus 是否锁定，用于改价0--未锁定，1--锁定
     */
    public void setLockStatus(Byte lockStatus) {
        this.lockStatus = lockStatus;
    }

    /**
     * 获取默认的商品缩略图
     *
     * @return thumbnail - 默认的商品缩略图
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 设置默认的商品缩略图
     *
     * @param thumbnail 默认的商品缩略图
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * 获取0--未删除，1--删除
     *
     * @return is_deleted - 0--未删除，1--删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置0--未删除，1--删除
     *
     * @param isDeleted 0--未删除，1--删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取是否保护，如果保护，不参加优惠计算
     *
     * @return isProtected - 是否保护，如果保护，不参加优惠计算
     */
    public Boolean getIsprotected() {
        return isprotected;
    }

    /**
     * 设置是否保护，如果保护，不参加优惠计算
     *
     * @param isprotected 是否保护，如果保护，不参加优惠计算
     */
    public void setIsprotected(Boolean isprotected) {
        this.isprotected = isprotected;
    }

    /**
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 获取商品标签，数据字典表的id
     *
     * @return tag_id - 商品标签，数据字典表的id
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * 设置商品标签，数据字典表的id
     *
     * @param tagId 商品标签，数据字典表的id
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     * @return deleted
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * @param deleted
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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
     * @return productImages
     */
    public String getProductimages() {
        return productimages;
    }

    /**
     * @param productimages
     */
    public void setProductimages(String productimages) {
        this.productimages = productimages;
    }
}