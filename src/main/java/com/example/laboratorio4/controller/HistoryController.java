package com.example.laboratorio4.controller;

import com.example.laboratorio4.entity.Departments;
import com.example.laboratorio4.entity.Employees;
import com.example.laboratorio4.entity.History;
import com.example.laboratorio4.entity.Jobs;
import com.example.laboratorio4.repository.DepartmentsRepository;
import com.example.laboratorio4.repository.EmployeesRepository;
import com.example.laboratorio4.repository.HistoryRepository;
import com.example.laboratorio4.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/history")
public class HistoryController {

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    JobsRepository jobRepository;
    @Autowired
    DepartmentsRepository despartmentsRepository;


    @GetMapping(value = {"","/"})
    public String historialEmpleado(Model model){
        List<Employees> listaEmployee = employeesRepository.findAll();
        List<History> listaHistory = historyRepository.findAll();
        List<Jobs> listaJob = jobRepository.findAll();
        List<Departments> listaDepartement = despartmentsRepository.findAll();
        model.addAttribute("listaEmployee",listaEmployee);
        model.addAttribute("listaHistory",listaHistory);
        model.addAttribute("listaJob",listaJob);
        model.addAttribute("listaDepartement",listaDepartement);

        return "history/lista";
    }



}
