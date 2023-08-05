package com.jspider.AssignmentCRUD.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer_info")
public class Customer {
    @javax.persistence.Id
    @Column(name = "id")
    private int Id;
    @Column(name = "first_name")
    private String Fname;
    @Column(name = "last_name")
    private String Lname;
    @Column(name = "address")
    private String Address;
    @Column(name = "city")
    private String City;
    @Column(name = "state")
    private String State;
    @Column(name = "email")
    private String Email;
    @Column(name = "phone")
    private long Phone;
}
