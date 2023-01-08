package com.example.mostfamousnames;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NameStatRepository extends CrudRepository<NameStat, Long> {

    @Query(value = "SELECT * FROM name_stat ORDER BY num DESC LIMIT 10", nativeQuery = true)
    List<NameStat> find10MostFamousNames();
}
