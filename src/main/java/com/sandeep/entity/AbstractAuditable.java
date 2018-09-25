/** AbstractAuditable.java */
package com.sandeep.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Abstract base class for auditable entities. Stores the audit values in
 * persistent fields. Persist or update date, createdBy, modifiedBy onPersist
 * and onUpdate.
 *
 * @author sandeep
 */
@MappedSuperclass
public abstract class AbstractAuditable {

    /** Created date. */
    @Basic
    @Column( name = "created_on", updatable = false )
    private Date createdDate;

    /** Last modified date. */
    @Basic
    @Column( name = "last_updated_on" )
    private Date lastModifiedDate;

    /** Created BY. */
    @Basic
    @Column( name = "created_by", updatable = false, columnDefinition = "CHAR(36)" )
    private String createdBy;

    /** Last modified By. */
    @Basic
    @Column( name = "last_updated_by", columnDefinition = "CHAR(36)" )
    private String lastModifiedBy;

    /**
     * This method returns the created date.
     *
     * @return <code>DateTime</code> object of created date.
     */
    public Date getCreatedDate() {
        return ( createdDate == null ) ? null : new Date( createdDate.getTime() );
    }

    /**
     * This method sets the created date.
     *
     * @param createdDate
     *            is the created date of object.
     */
    public void setCreatedDate( final Date createdDate ) {
        this.createdDate = ( createdDate == null ) ? null : new Date( createdDate.getTime() );
    }

    /**
     * This method returns the last modified date.
     *
     * @return <code>DateTime</code> object of last modified date.
     */
    public Date getLastModifiedDate() {
        return ( lastModifiedDate == null ) ? null : new Date( lastModifiedDate.getTime() );
    }

    /**
     * This method sets the last modified date.
     *
     * @param lastModifiedDate
     *            is the last modified By.
     */
    public void setLastModifiedDate( final Date lastModifiedDate ) {
        this.lastModifiedDate = ( lastModifiedDate == null ) ? null : new Date( lastModifiedDate.getTime() );
    }

    /**
     * This method returns the created By.
     *
     * @return <code>String</code> of created date.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method sets the created By.
     *
     * @param createdBy
     *            is the created date of object.
     */
    public void setCreatedBy( final String createdBy ) {
        this.createdBy = createdBy;
    }

    /**
     * This method returns the last modified By.
     *
     * @return <code>String</code> of last modified By.
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * This method sets the last modified By.
     *
     * @param lastModifiedBy
     *            is the last modified By.
     */
    public void setLastModifiedBy( final String lastModifiedBy ) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * This method sets the created date and last modified date for given
     * object. THis operation gets before persisting the object.
     */
    @PrePersist
    public void persistAuditInfo() {
        final Date currentDateTime = new Date();
        if (createdDate == null) {
            setCreatedDate( currentDateTime );
        }
        if (lastModifiedDate == null) {
            setLastModifiedDate( currentDateTime );
        }
        if(null == createdBy) {
        	setCreatedBy( "APPLICATION" );
        }
    }

    /**
     * This method sets the last modified date for given object. THis operation
     * gets before updating the object.
     */
    @PreUpdate
    public void updateAuditInfo() {
        final Date currentDateTime = new Date();
        if (lastModifiedDate == null) {
            setLastModifiedDate( currentDateTime );
        }
        if(null == lastModifiedBy || lastModifiedBy.length()==0) {
        	setLastModifiedBy("APPLICATION" );
        }
    }
}
