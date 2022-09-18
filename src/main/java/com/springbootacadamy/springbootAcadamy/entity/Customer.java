package com.springbootacadamy.springbootAcadamy.entity;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "customer") //apit ona vidhat table ekk hada gnnaw
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Customer {
    @Id
    @Column(name ="customer_id",length = 45) //apit ona vidihat hada gnn puluwn table eke clm eka
    @GeneratedValue(strategy = GenerationType.AUTO) //Auto generate kranna
    private int customerId;

    @Column(name = "customer_name",length =100, nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 255)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Type(type = "json")
    @Column(name = "contact_numbers",columnDefinition = "json") //multiple values awoth json ekakat danaw
    private ArrayList contactNumbers;
}
