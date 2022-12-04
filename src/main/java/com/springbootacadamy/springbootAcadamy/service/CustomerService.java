package com.springbootacadamy.springbootAcadamy.service;

import com.springbootacadamy.springbootAcadamy.dto.CustomerDTO;

import java.util.List;

public interface CustomerService{
    void addCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomer();
}
