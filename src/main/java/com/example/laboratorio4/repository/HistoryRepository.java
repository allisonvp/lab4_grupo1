package com.example.laboratorio4.repository;

import com.example.laboratorio4.dtos.historyDto;
import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {

    @Query(value="SELECT e.first_name as nombre, e.last_name as apellido, j.job_title as trabajo, date_format(date(subQuery.start_date),'%d-%m-%Y') as inicio, date_format(date(subQuery.end_date),'%d-%m-%Y') as fin, subQuery.anhostrabajados as anhos, subQuery.mesestrabajados as meses FROM employees e\n" +
            "right join (SELECT employee_id, start_date, end_date, job_id, FLOOR((DATEDIFF(end_date,start_date))/365) as anhostrabajados,\n" +
            "FLOOR((DATEDIFF(end_date,start_date)- (FLOOR((DATEDIFF(end_date,start_date))/365)*365))/30) as mesestrabajados\n" +
            "FROM job_history\n" +
            "order by anhostrabajados desc) subQuery \n" +
            "ON (e.employee_id= subQuery.employee_id)\n" +
            "left join jobs j ON j.job_id = e.job_id\n" +
            "order by subQuery.anhostrabajados desc",nativeQuery = true)
    List<historyDto> obtenerListaRecursosHumanos();

}
