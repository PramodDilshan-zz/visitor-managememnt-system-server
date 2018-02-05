package com.mobitel.repositiry;

import com.mobitel.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pramod-dilshan on 1/7/18.
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

}
