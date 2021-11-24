package com.bjit.repositories;

import com.bjit.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select name from customers where customer_id :=customerId", nativeQuery = true)
    public String getCustomerNameByCustomerIDd(@Param("customerId") Long cumstomerId);
}
