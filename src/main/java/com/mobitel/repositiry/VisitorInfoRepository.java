package com.mobitel.repositiry;

import com.mobitel.model.VisitorInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pramod-dilshan on 1/7/18.
 */

@Repository
public interface VisitorInfoRepository extends CrudRepository<VisitorInfo,String> {
}
