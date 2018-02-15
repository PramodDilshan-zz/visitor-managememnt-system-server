package com.mobitel.service;

import com.mobitel.model.VisitorInfo;
import com.mobitel.model.VisitorSchedule;
import com.mobitel.model.VisitorScheduleId;
import com.mobitel.repositiry.VisitorScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by pramod-dilshan on 1/26/18.
 */

@Service
public class ScheduleService {

    private final VisitorScheduleRepository visitorScheduleRepository;
    private final VisitorInfoService visitorInfoService;
    private final EmployeeService employeeService;
    private static VisitorInfo visitorInfo;
    private static VisitorSchedule visitorSchedule;
    private VisitorScheduleId visitorScheduleId = new VisitorScheduleId();
//    private static VisitorScheduleId visitorScheduleId = new VisitorScheduleId();


    @Autowired
    public ScheduleService(EmployeeService employeeService,
                           VisitorScheduleRepository visitorScheduleRepository,
                           VisitorInfoService visitorInfoService
                           ) {
        this.employeeService = employeeService;
        this.visitorScheduleRepository = visitorScheduleRepository;
        this.visitorInfoService = visitorInfoService;

    }


    public VisitorSchedule saveSchedule(String username,VisitorSchedule schedule) {
        visitorInfo = schedule.getVisitorInfo();
        this.visitorInfoService.saveVisitorInfo(visitorInfo);
        visitorSchedule = new VisitorSchedule(
                this.employeeService.findOne(username),
                visitorInfo,
                schedule.getVisitorScheduleId(),
                schedule.getPurpose(),
                schedule.getScheduleEndDate());
        return this.visitorScheduleRepository.save(visitorSchedule);

    }


    public List<VisitorSchedule> viewEmployeePendingList(String employeeUsername) {
        Date date = new Date();
        return this.visitorScheduleRepository.findByEmployeeUsernameWithDate(date,employeeUsername);
    }

    public VisitorSchedule findVisitorScheduleById(VisitorScheduleId visitorScheduleId){
        return this.visitorScheduleRepository.findOne(visitorScheduleId);
    }

    public void cancelSchedule(VisitorSchedule visitorSchedule) {

        visitorScheduleId = visitorSchedule.getVisitorScheduleId();
        visitorScheduleRepository.delete(visitorScheduleId);
    }
}
