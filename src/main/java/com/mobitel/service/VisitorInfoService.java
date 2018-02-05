package com.mobitel.service;

import com.mobitel.model.VisitorInfo;
import com.mobitel.repositiry.VisitorInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pramod-dilshan on 1/30/18.
 */

@Service
public class VisitorInfoService {


    private final VisitorInfoRepository visitorInfoRepository;


    @Autowired
    public VisitorInfoService(VisitorInfoRepository visitorInfoRepository){
        this.visitorInfoRepository = visitorInfoRepository;
    }

    public VisitorInfo saveVisitorInfo(VisitorInfo visitorInfo){
        return this.visitorInfoRepository.save(visitorInfo);
    }

    public VisitorInfo findVisitorInfoByVisitorId(String visitorId){
        return this.visitorInfoRepository.findOne(visitorId);
    }
}
