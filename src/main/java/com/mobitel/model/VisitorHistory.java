package com.mobitel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by pramod-dilshan on 1/7/18.
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "visitor_history")
public class VisitorHistory implements Serializable {


    private Date leavingDateTime;
    private int passno;
    private VisitorHistoryId visitorHistoryId;

    @JsonIgnore
    private VisitorSchedule visitorSchedule;


    public VisitorHistory(Date leavingDateTime,
                          int passno,
                          VisitorHistoryId visitorHistoryId,
                          VisitorSchedule visitorSchedule) {
        this.leavingDateTime = leavingDateTime;
        this.passno = passno;
        this.visitorHistoryId = visitorHistoryId;
        this.visitorSchedule = visitorSchedule;
    }

    public VisitorHistory() {
    }

    @Column
    public Date getLeavingDateTime() {
        return leavingDateTime;
    }

    public void setLeavingDateTime(Date leavingDateTime) {
        this.leavingDateTime = leavingDateTime;
    }

    @Column(nullable = false)
    public int getPassno() {
        return passno;
    }

    public void setPassno(int passno) {
        this.passno = passno;
    }


    @EmbeddedId
//    @AttributeOverride(name = "visitorId", column = @Column(name = "visitor_schedule_visitor_info_visitor_id"))
    public VisitorHistoryId getVisitorHistoryId() {
        return visitorHistoryId;
    }

    public void setVisitorHistoryId(VisitorHistoryId visitorHistoryId) {
        this.visitorHistoryId = visitorHistoryId;
    }

    @MapsId("visitorScheduleId")
    @ManyToOne
    public VisitorSchedule getVisitorSchedule() {
        return visitorSchedule;
    }

    public void setVisitorSchedule(VisitorSchedule visitorSchedule) {
        this.visitorSchedule = visitorSchedule;
    }
}
