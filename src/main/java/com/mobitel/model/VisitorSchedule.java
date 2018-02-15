package com.mobitel.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by pramod-dilshan on 1/25/18.
 */

@Entity
@Table(name = "visitor_schedule")
@EntityListeners(AuditingEntityListener.class)
public class VisitorSchedule implements Serializable {

    private String purpose;

    private Date scheduleEndDate;
    private VisitorScheduleId visitorScheduleId;

    private Employee employee;

    private VisitorInfo visitorInfo;

    @JsonIgnore
    private List<VisitorHistory> visitorHistories;



    public VisitorSchedule(Employee employee,
                           VisitorInfo visitorInfo,
                           VisitorScheduleId visitorScheduleId,
                           String purpose,
                           Date scheduleEndDate
                           ){
        this.setEmployee(employee);

        this.setVisitorScheduleId(visitorScheduleId);
        this.setVisitorInfo(visitorInfo);
        this.setPurpose(purpose);
        this.setScheduleEndDate(scheduleEndDate);
    }

    public VisitorSchedule(){}


    @Column(nullable = false)
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }



    @Column(nullable = false)
    public Date getScheduleEndDate() {
        return scheduleEndDate;
    }

    public void setScheduleEndDate(Date scheduleEndDate) {
        this.scheduleEndDate = scheduleEndDate;
    }


    @ManyToOne
    @JoinColumn(name = "employee_username")
    public Employee getemployee() {
        return employee;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @MapsId("visitorId")
    @ManyToOne
    public VisitorInfo getVisitorInfo() {

        return visitorInfo;
    }

    public void setVisitorInfo(VisitorInfo visitorInfo) {

        this.visitorInfo = visitorInfo;
    }

    @EmbeddedId
//    @AttributeOverrides(
//            {@AttributeOverride(name = "visitorId", column = @Column(name = "visitor_info_visitor_id")),
//             @AttributeOverride(name = "scheduleStartDate", column = @Column(name = "schedule_start_date"))})
    public VisitorScheduleId getVisitorScheduleId() {
        return visitorScheduleId;
    }

    public void setVisitorScheduleId(VisitorScheduleId visitorScheduleId) {
        this.visitorScheduleId = visitorScheduleId;
    }

    @OneToMany(mappedBy = "visitorSchedule")
    public List<VisitorHistory> getVisitorHistories() {
        return visitorHistories;
    }

    public void setVisitorHistories(List<VisitorHistory> visitorHistories) {
        this.visitorHistories = visitorHistories;
    }


}
