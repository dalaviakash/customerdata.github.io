package com.jspider.AssignmentCRUD.Controller;

import com.jspider.AssignmentCRUD.Model.Customer;
import com.jspider.AssignmentCRUD.Services.customerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class customerController {
    @Autowired
    public customerServices services;
    List<Customer>customerList=new ArrayList<>();  // crested one list to perform crud opration
    //show all data
@GetMapping("/index")
    public String getAllData(Model model){
    model.addAttribute("record",services.getAllData());
    return "index";

    }
    //open the add customer form
  @GetMapping("/addCustomer")
    public String addData(Model model){
    model.addAttribute("customer",new Customer());
            return "addCustomer";
    }
    //insert data in database
@PostMapping("/insertData")
    public String insertData(Customer c){
    services.insertData(c);
            return "redirect:/index";
}
//update data get all data in form
@GetMapping("/updateCustomer/{id}")
    public String updateData(@PathVariable(value = "id")int id,Model model){
    model.addAttribute("records",services.updateData(id));
            return "updateCustomer";
}

//modify and save
@PostMapping("/modify/{id}")
    public String modifyData(@PathVariable int id, @ModelAttribute("records") Customer c){
    Customer customer=services.updateData(id);
    customer.setId(id);
    customer.setFname(c.getFname());
    customer.setLname(c.getLname());
    customer.setAddress(c.getAddress());
    customer.setCity(c.getCity());
    customer.setState(c.getState());
    customer.setEmail(c.getEmail());
    customer.setPhone(c.getPhone());
    services.modifyData(customer);
    return "redirect:/index";
}

//delete data
@GetMapping("/delete/{id}")
    public String deleteData(@PathVariable(value = "id")int id){
    services.deleteData(id);
    return "redirect:/index";
}
}
