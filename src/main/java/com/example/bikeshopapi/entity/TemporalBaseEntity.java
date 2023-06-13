package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;

import org.hibernate.envers.Audited;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Audited
public abstract class TemporalBaseEntity {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @LastModifiedDate
    private Date lastModified;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @PreUpdate
    @PrePersist
    @PreRemove
    public void preUpdate() {
        lastModified = new Date();
        created = new Date();
    }

}