package com.springbootacadamy.springbootAcadamy.controller;

import com.springbootacadamy.springbootAcadamy.dto.CustomerDTO;
import com.springbootacadamy.springbootAcadamy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//to unique the controller
@RequestMapping("api/v1/customer")
@CrossOrigin

public class CustomerController {

    @Autowired
//    Singolton
    private CustomerService customerService;

    @PostMapping(path = "/save")
//    ena Json eka DTO ekk kra ganna RequestBody use kranw
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(customerDTO);
        return "saved";

    }
    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO){
        String updated = customerService.updateCustomer(customerDTO);
        return updated;

    }
    @GetMapping(path = "/get-by-id", params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return  customerDTO;
    }

    @GetMapping(path ="get=all-customers" )
    public List<CustomerDTO> getAllCustomers(){
       List<CustomerDTO> allCustomer = customerService.getAllCustomer();
       return allCustomer;

    }

}
