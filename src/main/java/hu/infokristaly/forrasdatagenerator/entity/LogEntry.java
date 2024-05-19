package hu.infokristaly.forrasdatagenerator.entity;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class LogEntry {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="loggedByUser")    
    private SystemUser loggedByUser;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date logTimestamp; 

    @Lob
    @Column(columnDefinition="text")
    private String loggedValue;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="loggedFunction")    
    private LoggedFunction loggedFunction;
    
    @Basic
    private byte action;
    
    public Long getId() {
        return id;
    }

    public SystemUser getLoggedByUser() {
        return loggedByUser;
    }

    public Date getLogTimestamp() {
        return logTimestamp;
    }

    public String getLoggedValue() {
        return loggedValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLoggedByUser(SystemUser loggedByUser) {
        this.loggedByUser = loggedByUser;
    }

    public void setLogTimestamp(Date logTimestamp) {
        this.logTimestamp = logTimestamp;
    }

    public void setLoggedValue(String loggedValue) {
        this.loggedValue = loggedValue;
    }

    public LoggedFunction getLoggedFunction() {
        return loggedFunction;
    }

    public void setLoggedFunction(LoggedFunction loggedFunction) {
        this.loggedFunction = loggedFunction;
    }

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }
    
}
