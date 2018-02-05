package com.mobitel.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pramod-dilshan on 1/26/18.
 */
@Embeddable
public class VisitorScheduleId implements Serializable{




    private Date scheduleStartDate;
    private String visitorId;

    public VisitorScheduleId(){}



    @Column(nullable = false, name = "schedule_start_date")
    public Date getScheduleStartDate() {
        return scheduleStartDate;
    }

    public void setScheduleStartDate(Date scheduleStartDate) {
        this.scheduleStartDate = scheduleStartDate;
    }


    @Column(nullable = false, name = "visitor_info_visitor_id")
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }
}
