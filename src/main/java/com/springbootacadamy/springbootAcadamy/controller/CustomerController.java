package com.springbootacadamy.springbootAcadamy.controller;

import com.springbootacadamy.springbootAcadamy.dto.CustomerDTO;
import com.springbootacadamy.springbootAcadamy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//to unique the controller
@RequestMapping("api/v1/customer")
@CrossOrigin

public class CustomerController {

    @Autowired
//    Singolton
    private CustomerService customerService;

    @PostMapping(path = "/save")
//    ena Json eka DTO ekk kra ganna  w
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(customerDTO);
        return "saved";

    }
}