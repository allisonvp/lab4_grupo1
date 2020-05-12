package com.example.laboratorio4.entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name="employees")
public class Employees {

    //COMPLETAR
    @Id
    @Column(name="employee_id")
    private String employeeid;
    @Column(name="first_name")
    @NotBlank(message = "No puede estar vacío")
    @Size(max = 20, message = "El nombre no puede tener más de 20 caracteres")
    private String firstname;
    @Column(nullable = false, name="last_name")
    @NotBlank(message = "No puede estar vacío")
    @Size(max = 25, message = "El apellido no puede tener más de 25 caracteres")
    private String lastname;
    @Column(nullable = false)
    @Size(max = 25, message = "El correo no puede tener más de 25 caracteres")
    private String email;
    @Size(max = 25, message = "El teléfono no puede tener más de 25 caracteres")
    private String phone_number;

    @Column(nullable = false)
    private LocalDate hire_date;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs job;
    @Digits(integer = 8, fraction = 2)
    private BigDecimal salary;
    @Digits(integer = 2, fraction = 2)
    private BigDecimal commission_pct;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;


    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(BigDecimal commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Employees getManager() {
        return manager;
    }

    public void setManager(Employees manager) {
        this.manager = manager;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }
}
