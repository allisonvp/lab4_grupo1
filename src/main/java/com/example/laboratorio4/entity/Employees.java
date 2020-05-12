package com.example.laboratorio4.entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="employees")
public class Employees {

    //COMPLETAR
    @Id
    @Column(name="employee_id")
    private int employeeid;
    @Column(name="first_name")
    @NotBlank(message = "No puede estar vacío")
    @Size(max = 20, message = "El nombre no puede tener más de 20 caracteres")
    private String firstname;
    @Column(nullable = false, name="last_name")
    @NotBlank(message = "No puede estar vacío")
    @Size(max = 25, message = "El apellido no puede tener más de 25 caracteres")
    private String lastname;
    @Column(nullable = false)
    @NotBlank(message = "No puede estar vacío")
    @Size(max = 25, message = "El correo no puede tener más de 25 caracteres")
    private String email;
    @NotBlank(message = "No puede estar vacío")

    @NotBlank(message = "No puede estar vacío ni blanco")
    @Size(min = 8, message = "Debe tener un mínimo de 8 caracteres")
    @Size(max = 36, message = "Debe tener un máximo de 36 caracteres")
    private String password;
    @Size(max = 25, message = "El teléfono no puede tener más de 25 caracteres")
    private String phone_number;

    @Column(nullable = false, name = "hire_date")
    private Date hiredate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs job;
    @Digits(integer = 8, fraction = 2)
    @Positive(message = "Tiene que ser mayor que 0")
    private BigDecimal salary;
    @Digits(integer = 2, fraction = 2)
    private BigDecimal commission_pct;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
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

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hire_date) {
        this.hiredate = hire_date;
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
