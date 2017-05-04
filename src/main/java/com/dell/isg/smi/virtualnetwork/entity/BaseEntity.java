/**
 * Copyright � 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.virtualnetwork.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.dell.isg.smi.virtualnetwork.configuration.TableConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author steve_heracleous - 2014
 *
 */
@Entity
@Table(name = "base_entity")
@XmlRootElement(name = "base_entity")
@JsonIgnoreProperties(ignoreUnknown = true)
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id")
public abstract class BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 251527491407883452L;


    public BaseEntity() {
        super();
        objectType = this.getClass().getName();
    }

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = TableConstants.SEQUENCE_ENTITY, sequenceName = TableConstants.SEQUENCE_ENTITY, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TableConstants.SEQUENCE_ENTITY)
    private long id;

    @Column(name = "object_type")
    // service_port
    private final String objectType;

    @Column(name = "created_by", nullable = true, length = 510)
    private String createdBy;

    @Column(name = "updated_by", nullable = true, length = 510)
    private String updatedBy;

    @Column(name = "created_time", insertable = false, updatable = false, columnDefinition = "timestamp default now()")
    private Date createdTime;

    @Column(name = "updated_time", insertable = false, updatable = false, columnDefinition = "timestamp default now()")
    private Date updatedTime;


    public Date getCreatedTime() {
        return createdTime;
    }


    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public String getObjectType() {
        return objectType;
    }


    public long getId() {
        return id;
    }


    public void setId(final long id) {
        this.id = id;
    }


    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }


    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }


    /**
     * @return the updatedBy
     */
    public String getUpdatedBy() {
        return updatedBy;
    }


    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }


    /**
     * @return the updatedTime
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }


    /**
     * @param updateTime the updatedTime to set
     */
    public void setUpdatedTime(final Date updatedTime) {
        this.updatedTime = updatedTime;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
        result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((objectType == null) ? 0 : objectType.hashCode());
        result = prime * result + ((updatedTime == null) ? 0 : updatedTime.hashCode());
        result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (createdBy == null) {
            if (other.createdBy != null) {
                return false;
            }
        } else if (!createdBy.equals(other.createdBy)) {
            return false;
        }
        if (createdTime == null) {
            if (other.createdTime != null) {
                return false;
            }
        } else if (!createdTime.equals(other.createdTime)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (objectType == null) {
            if (other.objectType != null) {
                return false;
            }
        } else if (!objectType.equals(other.objectType)) {
            return false;
        }
        if (updatedTime == null) {
            if (other.updatedTime != null) {
                return false;
            }
        } else if (!updatedTime.equals(other.updatedTime)) {
            return false;
        }
        if (updatedBy == null) {
            if (other.updatedBy != null) {
                return false;
            }
        } else if (!updatedBy.equals(other.updatedBy)) {
            return false;
        }

        return true;
    }
}
