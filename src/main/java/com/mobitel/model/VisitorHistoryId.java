package com.mobitel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pramod-dilshan on 1/26/18.
 */

@Embeddable
public class VisitorHistoryId implements Serializable{

    private Date arrivedDateTime;
    private VisitorScheduleId visitorScheduleId;


    @Column(nullable = false)
    public Date getArrivedDateTime() {
        return arrivedDateTime;
    }

    public void setArrivedDateTime(Date arrivedDateTime) {
        this.arrivedDateTime = arrivedDateTime;
    }

    public VisitorScheduleId getVisitorScheduleId() {
        return visitorScheduleId;
    }

    public void setVisitorScheduleId(VisitorScheduleId visitorScheduleId) {
        this.visitorScheduleId = visitorScheduleId;
    }
}

