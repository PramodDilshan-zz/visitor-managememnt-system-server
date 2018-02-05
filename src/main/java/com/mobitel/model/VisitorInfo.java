package com.mobitel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by pramod-dilshan on 1/7/18.
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "visitor_info")
public class VisitorInfo implements Serializable {


    private String visitorId;
    private String organization;
    private String name;

    @JsonIgnore
    private List<VisitorSchedule> visitorSchedules;

    @Id
    @Column(nullable = false)
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    @Column(nullable = false)
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @OneToMany(mappedBy = "visitorInfo")
    public List<VisitorSchedule> getVisitorSchedules() {
        return visitorSchedules;
    }

    public void setVisitorSchedules(List<VisitorSchedule> visitorSchedules) {
        this.visitorSchedules = visitorSchedules;
    }
}
