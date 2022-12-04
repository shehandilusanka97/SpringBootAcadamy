package com.springbootacadamy.springbootAcadamy.service.impl;

import com.springbootacadamy.springbootAcadamy.dto.CustomerDTO;
import com.springbootacadamy.springbootAcadamy.entity.Customer;
import com.springbootacadamy.springbootAcadamy.repo.CustomerRepo;
import com.springbootacadamy.springbootAcadamy.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

//    Dependency injection
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumbers(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );
        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
        } else {
            System.out.println("Customer id Already  Exists");
        }
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())){
            Customer customer = customerRepo.getById(customerDTO.getCustomerId());

            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());

            customerRepo.save(customer);
            return "updated";

        }else{
            System.out.println("No customer found for this id");
            return "No customer found for this id";
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
//        Customer customer = customerRepo.getById(customerId);
//        if (customer!=null){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getCustomerSalary(),
//                    customer.getContactNumbers(),
//                    customer.getNic(),
//                    customer.isActiveState()
//
//            );
//            return customerDTO;
//        }else{
//            return null;
//        }

//        find by id eken krna vidiha
//        Optional<Customer> customer = customerRepo.findById(customerId);
//        if (customer.isPresent()){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.get().getCustomerId(),
//                    customer.get().getCustomerName(),
//                    customer.get().getCustomerAddress(),
//                    customer.get().getCustomerSalary(),
//                    customer.get().getContactNumbers(),
//                    customer.get().getNic(),
//                    customer.get().isActiveState()
//
//            );
//            return customerDTO;
//        }else{
//            return null;
//        }

//        Model Mapperrrrr
        Customer customer = customerRepo.getById(customerId);
//        denta thiyana thiyana eka , eka convert wena eka(DTO).class
        CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
        return customerDTO;

    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomer = customerRepo.findAll();

        return null;
    }
}
