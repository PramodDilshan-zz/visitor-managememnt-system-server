package com.mobitel.controller;


import com.mobitel.model.VisitorHistory;
import com.mobitel.repositiry.VisitorHistoryRepository;
import com.mobitel.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pramod-dilshan on 1/7/18.
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/{username}/history")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<VisitorHistory> findHistoryList(){
        return historyService.findHistoryList();
    }


}

