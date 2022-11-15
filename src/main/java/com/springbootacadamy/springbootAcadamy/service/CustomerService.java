package com.springbootacadamy.springbootAcadamy.service;

import com.springbootacadamy.springbootAcadamy.dto.CustomerDTO;

public interface CustomerService{
    void addCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);
}
