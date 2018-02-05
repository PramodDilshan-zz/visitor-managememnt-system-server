package com.mobitel.repositiry;

import com.mobitel.model.Employee;
import com.mobitel.model.VisitorSchedule;
import com.mobitel.model.VisitorScheduleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by pramod-dilshan on 1/26/18.
 */
public interface VisitorScheduleRepository extends JpaRepository<VisitorSchedule,VisitorScheduleId> {



//    List<VisitorSchedule> findByEmployee(Employee employee);

    List<VisitorSchedule> findByEmployeeUsername(String employeeUsername);

//    List<VisitorSchedule> findByEmployeeIgnoreCase(Employee employee);

//    List<Person> findByLastnameIgnoreCase(String lastname);
}


