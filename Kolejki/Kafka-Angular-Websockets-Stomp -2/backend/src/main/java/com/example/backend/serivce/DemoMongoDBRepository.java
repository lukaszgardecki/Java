package com.example.backend.serivce;

import com.example.backend.model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DemoMongoDBRepository extends JpaRepository<DataModel, Long> {

    //Supports native JSON query string
    @Query("SELECT d FROM DataModel d WHERE d.saleTimestamp > :date")
    List<DataModel> findSalesGreaterThanDate(@Param("date") LocalDate date);
}
