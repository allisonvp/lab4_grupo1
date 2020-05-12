package com.example.laboratorio4.repository;

import com.example.laboratorio4.dtos.empleadoPorDepa;
import com.example.laboratorio4.dtos.empleadoSalario;
import com.example.laboratorio4.dtos.salarioPromDepa;
import com.example.laboratorio4.entity.Departments;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {

    @Query(value="SELECT d.department_id as 'depaid', department_name as 'depaname', AVG(e.salary) as 'promedio'\n" +
            "FROM departments d\n" +
            "inner join employees e on d.department_id=e.department_id\n" +
            "group by d.department_id\n" +
            "order by AVG(e.salary) DESC",nativeQuery=true)
    List<salarioPromDepa> obtenerSalariopromdepa();


    @Query(value="SELECT e.employee_id as 'empid', e.first_name as 'empname', e.last_name as 'emplast', j.job_title as 'cargo', e.salary as 'sueldo'\n" +
            "FROM employees e\n" +
            "left join jobs j on e.job_id=j.job_id\n" +
            "where department_id=? \n" +
            "order by e.salary DESC",nativeQuery=true)
    List<empleadoPorDepa> obtenerEmpPorDepa(int id);

    @Query(value="SELECT e.first_name as 'name' ,e.last_name as 'last' ,  date_format(date(jh.start_date),'%d-%m-%Y') as 'fechainicio',date_format(date(jh.end_date),'%d-%m-%Y') as 'fechafin', j.job_title as 'puesto'\n" +
            "FROM job_history jh\n" +
            "left join employees e on e.employee_id=jh.employee_id\n" +
            "left join jobs j on j.job_id=e.job_id\n" +
            "where e.salary >=8000;",nativeQuery=true)
    List<empleadoSalario> buscarMayorSalario();

    @Query(value="SELECT e.first_name as 'name' ,e.last_name as 'last' ,  date_format(date(jh.start_date),'%d-%m-%Y') as 'fechainicio',date_format(date(jh.end_date),'%d-%m-%Y') as 'fechafin', j.job_title as 'puesto'\n" +
            "FROM job_history jh\n" +
            "left join employees e on e.employee_id=jh.employee_id\n" +
            "left join jobs j on j.job_id=e.job_id\n" +
            "where e.salary =?;",nativeQuery=true)
    List<empleadoSalario> buscarPorSalario(int salary);



}
