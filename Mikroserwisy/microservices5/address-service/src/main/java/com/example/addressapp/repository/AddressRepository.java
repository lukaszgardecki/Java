package com.example.addressapp.repository;

import com.example.addressapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "SELECT * FROM address WHERE employee_id=:employeeId", nativeQuery = true)
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") Long employeeId);

}
