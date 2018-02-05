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
    List<VisitorHistory> findByLeavingDateTime(Date date);

}