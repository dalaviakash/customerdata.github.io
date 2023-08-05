package com.jspider.AssignmentCRUD.Services;

import com.jspider.AssignmentCRUD.Model.Customer;
import com.jspider.AssignmentCRUD.Repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerServices {
    //inherited repository
    @Autowired
    public customerRepository repository;

    //show data
    public List<Customer> getAllData() {
        List<Customer>customerList=repository.findAll();
        return customerList;

    }
    //show form for add data
 public void addData(Customer c){
        repository.save(c);
 }
 //add data in database
    public void insertData(Customer c) {
       repository.save(c);
    }

    //update data open form
    public Customer updateData(int id){
       return repository.findById(id).get();
    }

    //modify data inserte
    public void modifyData(Customer customer) {
        repository.save(customer);
    }
//delete data
    public void deleteData(int id) {
        repository.deleteById(id);
    }
}
