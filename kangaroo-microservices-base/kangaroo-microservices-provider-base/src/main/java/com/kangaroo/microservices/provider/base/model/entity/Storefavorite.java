package com.kangaroo.microservices.provider.base.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`StoreFavorite`")
public class Storefavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdDate")
    private Date createddate;

    @Column(name = "lastModifiedDate")
    private Date lastmodifieddate;

    private Long version;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "store_id")
    private Long storeId;

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
     * @return member_id
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
}