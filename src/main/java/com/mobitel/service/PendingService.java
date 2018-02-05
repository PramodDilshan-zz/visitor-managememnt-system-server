package com.mobitel.service;

import com.mobitel.model.VisitorHistory;
import com.mobitel.model.VisitorSchedule;
import com.mobitel.repositiry.VisitorHistoryRepository;
import com.mobitel.repositiry.VisitorScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pramod-dilshan on 1/26/18.
 */

@Service
public class PendingService {

    private final VisitorScheduleRepository visitorScheduleRepository;
    private final VisitorHistoryRepository visitorHistoryRepository;
    private final EmployeeService employeeService;

    public PendingService(VisitorScheduleRepository visitorScheduleRepository,
                          VisitorHistoryRepository visitorHistoryRepository,
                          EmployeeService employeeService) {
        this.visitorScheduleRepository = visitorScheduleRepository;
        this.visitorHistoryRepository = visitorHistoryRepository;
        this.employeeService = employeeService;
    }


    public List<VisitorSchedule> viewAllPendingList(String username) {
        this.employeeService.validateUser(username);
        return visitorScheduleRepository.findAll();
    }


}
