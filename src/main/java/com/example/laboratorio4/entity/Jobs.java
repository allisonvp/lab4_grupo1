package com.example.laboratorio4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @Column(name = "job_id")
    private String jobid;
    @Size(max = 35, message = "El nombre no puede tener más de 35 caracteres")
    @Column(name = "job_title",nullable = false)
    private String jobtitle;
    @Max(value = 6, message = "El salario máximo no puede tener más de 6 digitos")
    @Column(name = "min_salary")
    private int minsalary;
    @Max(value = 6, message = "El salario mínimo no puede tener más de 6 digitos")
    @Column(name = "max_salary")
    private int maxsalary;

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public int getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(int minsalary) {
        this.minsalary = minsalary;
    }

    public int getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(int maxsalary) {
        this.maxsalary = maxsalary;
    }
}
