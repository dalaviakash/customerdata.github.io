package com.jspider.AssignmentCRUD.Repository;

import com.jspider.AssignmentCRUD.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<Customer,Integer> {
}
