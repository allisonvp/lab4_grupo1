package com.example.laboratorio4.controller;


import com.example.laboratorio4.dtos.empleadoPorDepa;
import com.example.laboratorio4.dtos.salarioPromDepa;
import com.example.laboratorio4.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    DepartmentsRepository departmentsRepository;

    @GetMapping(value = {"", "/"})
    public String indice() {
        return "Search/indice";
    }

    @GetMapping(value = {"/Salario"})
    public String listaEmpleadosMayorSalario() {

        //COMPLETAR
        return "Search/lista2";
    }

    @PostMapping("/busqueda")
    public String buscar() {

        //COMPLETAR
        return "";
    }

    @GetMapping(value = "/Filtro2")
    public String cantidadEmpleadosPorPais(Model m) {

        List<salarioPromDepa> salarioPromDepas = departmentsRepository.obtenerSalariopromdepa();
        m.addAttribute("lista",salarioPromDepas);
        return "/Search/salario";
    }

    @GetMapping("/listar")
    public String listarEmpleadoDep(@RequestParam("id") int depaid,Model m) {
        List<empleadoPorDepa> empleadoPorDepas = departmentsRepository.obtenerEmpPorDepa(depaid);
        m.addAttribute("lista",empleadoPorDepas);

        return "/Search/lista3";

    }


}
