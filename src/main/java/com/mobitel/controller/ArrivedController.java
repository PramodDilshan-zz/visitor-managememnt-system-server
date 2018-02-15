package com.mobitel.controller;

import com.mobitel.model.VisitorHistory;
import com.mobitel.model.VisitorHistoryId;
import com.mobitel.service.ArrivedService;
import com.mobitel.service.EmployeeService;
import com.mobitel.service.HistoryService;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.ATR;
import java.util.List;

/**
 * Created by pramod-dilshan on 1/30/18.
 */
@CrossOrigin
@RestController
@RequestMapping("/{username}/arrived")
public class ArrivedController {

    private final ArrivedService arrivedService;
    private final EmployeeService employeeService;
    private final HistoryService historyService;


    public ArrivedController(ArrivedService arrivedService,
                             EmployeeService employeeService,
                             HistoryService historyService){
        this.arrivedService = arrivedService;
        this.employeeService = employeeService;
        this.historyService = historyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<VisitorHistory> findArrivedList(@PathVariable String username){
        this.employeeService.validateUser(username);
        return this.arrivedService.findArrivedList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void markAsLeave(@PathVariable String username, @RequestBody VisitorHistoryId visitorHistoryId){
        this.employeeService.validateUser(username);
        this.historyService.markAsLeave(visitorHistoryId);
    }
}
