package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    private long id;
    private String name;
    private String role;
    private String emailAddress;
 
    public Employee() {
  
    }
 
    public Employee(String name, String role, String email_address) {
         this.name = name;
         this.role = role;
         this.emailAddress = emailAddress;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "name", nullable = false)
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
 
    @Column(name = "role", nullable = false)
    public String getrole() {
        return role;
    }
    public void setrole(String role) {
        this.role = role;
    }
 
    @Column(name = "emailAddress", nullable = false)
    public String getemailAddress() {
        return emailAddress;
    }
    public void setemailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", emailAddress=" + emailAddress
       + "]";
    }
 
}
