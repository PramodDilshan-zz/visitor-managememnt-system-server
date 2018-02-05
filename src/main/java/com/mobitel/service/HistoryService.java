package com.mobitel.service;


import com.mobitel.model.VisitorHistory;
import com.mobitel.model.VisitorHistoryId;
import com.mobitel.repositiry.VisitorHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by pramod-dilshan on 1/26/18.
 */
@Service
public class HistoryService {


    private final VisitorHistoryRepository visitorHistoryRepository;
    private static VisitorHistory visitorHistory;

    @Autowired
    public HistoryService(VisitorHistoryRepository visitorHistoryRepository) {
        this.visitorHistoryRepository = visitorHistoryRepository;
        visitorHistory = new VisitorHistory();
    }

    public VisitorHistory markAsArrived(VisitorHistory visitorHistory) {
        return this.visitorHistoryRepository.save(visitorHistory);
    }

    public void markAsLeave(VisitorHistoryId visitorHistoryId){
        visitorHistory = this.visitorHistoryRepository.findOne(visitorHistoryId);
        visitorHistory.setLeavingDateTime(new Date());
    }

    public List<VisitorHistory> findHistoryList() {
        return this.visitorHistoryRepository.findAll();
    }
}
