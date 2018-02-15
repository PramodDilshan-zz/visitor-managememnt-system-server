package com.mobitel.repositiry;

import com.mobitel.model.VisitorHistory;
import com.mobitel.model.VisitorHistoryId;
import com.mobitel.model.VisitorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by pramod-dilshan on 1/7/18.
 */

@Repository
public interface VisitorHistoryRepository extends JpaRepository<VisitorHistory,VisitorHistoryId> {



    @Query("select v from VisitorHistory v where v.visitorSchedule.scheduleEndDate > ?1 and v.leavingDateTime = null")
    List<VisitorHistory> findByLeavingDateTimeWithDate(Date date);


    List<VisitorHistory> findAllByOrderByLeavingDateTimeDesc();
}