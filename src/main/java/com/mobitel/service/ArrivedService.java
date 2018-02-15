package com.mobitel.service;

import com.mobitel.model.VisitorHistory;
import com.mobitel.model.VisitorSchedule;
import com.mobitel.model.VisitorScheduleId;
import com.mobitel.repositiry.VisitorHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by pramod-dilshan on 1/26/18.
 */
@Service
public class ArrivedService {
    private static VisitorSchedule visitorSchedule;
    private static VisitorScheduleId visitorScheduleId;
    private static VisitorHistory visitorHistory;
    private final VisitorHistoryRepository visitorHistoryRepository;
    private final ScheduleService scheduleService;
    private final HistoryService HistoryService;



    @Autowired
    public ArrivedService(VisitorHistoryRepository visitorHistoryRepository,
                          ScheduleService scheduleService,
                          HistoryService HistoryService) {
        this.visitorHistoryRepository = visitorHistoryRepository;
        this.scheduleService = scheduleService;
        this.HistoryService = HistoryService;
        visitorSchedule = new VisitorSchedule();
        visitorHistory = new VisitorHistory();
        visitorScheduleId = new VisitorScheduleId();
    }

    public VisitorHistory markAsArrived(VisitorHistory visitorHistoryInc) {
        visitorScheduleId = visitorHistoryInc.getVisitorHistoryId().getVisitorScheduleId();
        visitorSchedule = this.scheduleService.findVisitorScheduleById(visitorScheduleId);
        this.visitorHistory = new VisitorHistory(null, visitorHistoryInc.getPassno(), visitorHistoryInc.getVisitorHistoryId(), visitorSchedule);
        return this.HistoryService.markAsArrived(this.visitorHistory);

    }

    public List<VisitorHistory> findArrivedList() {
        Date date = new Date();
        return this.visitorHistoryRepository.findByLeavingDateTimeWithDate(date);
    }
}

