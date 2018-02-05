package com.mobitel.controller;

import com.mobitel.model.VisitorInfo;
import com.mobitel.model.VisitorSchedule;
import com.mobitel.service.EmployeeService;
import com.mobitel.service.ScheduleService;
import com.mobitel.service.VisitorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pramod-dilshan on 1/26/18.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/{username}/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final VisitorInfoService visitorInfoService;
    private final EmployeeService employeeService;


    @Autowired
    ScheduleController(ScheduleService scheduleService,
                       VisitorInfoService visitorInfoService,
                       EmployeeService employeeService) {
        this.scheduleService = scheduleService;
        this.visitorInfoService = visitorInfoService;
        this.employeeService = employeeService;


    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<VisitorInfo> findVisitorInfo(@PathVariable String username, @RequestParam("id") String visitorId) {
        this.employeeService.validateUser(username);
        VisitorInfo visitorInfo = this.visitorInfoService.findVisitorInfoByVisitorId(visitorId);
        return new ResponseEntity<>(visitorInfo, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<VisitorSchedule> saveSchedule(@PathVariable String username, @RequestBody VisitorSchedule schedule) {
        this.employeeService.validateUser(username);
        VisitorSchedule visitorSchedule = this.scheduleService.saveSchedule(username, schedule);
        return new ResponseEntity<>(visitorSchedule, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/pending-list")
    public ResponseEntity<List<VisitorSchedule>> viewEmployeePendingList(@PathVariable String username) {
        this.employeeService.validateUser(username);
        List<VisitorSchedule> visitorSchedules = this.scheduleService.viewEmployeePendingList(username);
        return new ResponseEntity<>(visitorSchedules, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete")
    public ResponseEntity<Void> cancelSchedule(@PathVariable String username, @RequestBody VisitorSchedule visitorSchedule) {
        this.employeeService.validateUser(username);
        this.scheduleService.cancelSchedule(visitorSchedule);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
