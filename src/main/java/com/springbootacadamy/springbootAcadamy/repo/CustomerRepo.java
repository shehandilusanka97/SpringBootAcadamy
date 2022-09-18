package com.springbootacadamy.springbootAcadamy.repo;

import com.springbootacadamy.springbootAcadamy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
      //<Entity eka and Primary key eke type eka>
public interface CustomerRepo extends JpaRepository<Customer ,Integer> {
}
