package com.ekosutrisno.searching.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.Date;

/**
 * @author Eko Sutrisno
 * Thursday, 04/03/2021 14:50
 */

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer promotionId;

    @Column(nullable = false)
    @Size(min = 10, max = 150)
    @NotEmpty
    private String promotionDesc;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date validFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date validTo;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdDate;

    @Column(nullable = false)
    private OffsetDateTime lastUpdatedDate;

    public Promotion() {
    }

    public Promotion(Integer promotionId, String promotionDesc, Date validFrom, Date validTo, OffsetDateTime createdDate, OffsetDateTime lastUpdatedDate) {
        this.promotionId = promotionId;
        this.promotionDesc = promotionDesc;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @PrePersist
    public void prePersist() {
        createdDate = OffsetDateTime.now();
        lastUpdatedDate = createdDate;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdatedDate = OffsetDateTime.now();
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionDesc() {
        return promotionDesc;
    }

    public void setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public OffsetDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(OffsetDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}

