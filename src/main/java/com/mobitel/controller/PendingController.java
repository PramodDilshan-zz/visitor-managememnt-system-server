package com.mobitel.controller;

import com.mobitel.model.Employee;
import com.mobitel.model.VisitorHistory;
import com.mobitel.model.VisitorSchedule;
import com.mobitel.service.ArrivedService;
import com.mobitel.service.EmployeeService;
import com.mobitel.service.PendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pramod-dilshan on 1/7/18.
 */

@RestController
@RequestMapping("/{username}/pending")
public class PendingController {

    private final PendingService pendingService;
    private final ArrivedService arrivedService;
    private final EmployeeService employeeService;

    @Autowired
    public PendingController(PendingService pendingService,
                             ArrivedService arrivedService,
                             EmployeeService employeeService
                             ) {
        this.pendingService = pendingService;
        this.arrivedService = arrivedService;
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<VisitorSchedule> findAllPendingList(@PathVariable String username) {
        return this.pendingService.viewAllPendingList(username);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/isArrived")
    public VisitorHistory markAsArrived(@PathVariable String username, @RequestBody VisitorHistory visitorHistory){
        this.employeeService.validateUser(username);
        return this.arrivedService.markAsArrived(visitorHistory);
    }

}
