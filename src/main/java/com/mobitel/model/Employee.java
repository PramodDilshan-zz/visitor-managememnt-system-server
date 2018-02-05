package com.mobitel.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by pramod-dilshan on 1/7/18.
 */

@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)

public class Employee implements Serializable{


    private String username;
    private String password;
    private String privilageLvl;
    private String fullname;
    private String section;
    private String floor;
    private String mobileNumber;

    private List<VisitorSchedule> visitorSchedules;

    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Column(nullable = false)
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Column(nullable = false)
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Column(nullable = false)
    public String getPrivilageLvl() {
        return privilageLvl;
    }

    public void setPrivilageLvl(String privilageLvl) {
        this.privilageLvl = privilageLvl;
    }

    @Column(nullable = false)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @OneToMany(mappedBy = "employee")
    public List<VisitorSchedule> getVisitorSchedules() {
        return visitorSchedules;
    }

    public void setVisitorSchedules(List<VisitorSchedule> visitorSchedules) {
        this.visitorSchedules = visitorSchedules;
    }
}
