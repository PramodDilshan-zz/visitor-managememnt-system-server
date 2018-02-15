package com.mobitel.repositiry;

import com.mobitel.model.Employee;
import com.mobitel.model.VisitorSchedule;
import com.mobitel.model.VisitorScheduleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;


/**
 * Created by pramod-dilshan on 1/26/18.
 */
public interface VisitorScheduleRepository extends JpaRepository<VisitorSchedule,VisitorScheduleId> {




//    List<VisitorSchedule> findByEmployee(Employee employee);

    @Query("select v from VisitorSchedule v where v.scheduleEndDate > ?1 and v.employee.username = ?2 order by v.scheduleEndDate")
    List<VisitorSchedule> findByEmployeeUsernameWithDate(Date date, String employeeUsername);

//    select c from Customer c join c.addresses a where (a.city = :cityName)
    @Query("select DISTINCT vs from VisitorSchedule vs " +
            "join vs.visitorHistories vh " +
            "where vs.scheduleEndDate >= ?1 " +
            "and (vh.visitorHistoryId.arrivedDateTime < ?1 or vh.visitorHistoryId.arrivedDateTime = null)")
    List<VisitorSchedule> findAllWithdate(Date date);

//    List<VisitorSchedule> findByEmployeeIgnoreCase(Employee employee);

//    List<Person> findByLastnameIgnoreCase(String lastname);
}


