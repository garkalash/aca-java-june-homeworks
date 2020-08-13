package com.aca.naresilanyan.jsonHomework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Manager {
    private Map<String, Long>  workersCountBySections;
    private Integer workersCountGreater50;
    private Double spendMoney;
    private String affectedSection;
    private Double averageIncrease;
    private String maxIncreasedEmployee;
    private String minIncreasedEmployee;
    private Double initialSalary;

    public Double getInitialSalary() {
        return initialSalary;
    }

    public void setInitialSalary(Double initialSalary) {
        this.initialSalary = initialSalary;
    }


//1.1


    public void increaseSalary(Integer integer, List<Employee> employees){
        setInitialSalary(employees.stream().mapToDouble(value -> value.getSalary()).sum());
        double coefficient = 1+ (double)integer/100;
        for(Employee employee:employees){

            if(employee.getAge()>50){

                employee.setSalary(employee.getSalary()*coefficient);

            }
        }


    }

//2.1


    public Map<String, Long> countEmployeePerSection(List<Employee> employees){
        return employees
                .stream()
                .collect(Collectors.groupingBy(employee -> employee.getSection(), Collectors.counting()));

    }

    public Long countEmployeesgreater50(List<Employee>employees){
        return employees.stream().filter(employee -> employee.getAge()>50).count();
    }

//  2.2

    public Double companyExpanses(List<Employee> employees){


         Double increased = employees.stream().mapToDouble(value -> value.getSalary()).sum();
         if(initialSalary == increased){
             return 0.0;
         }else {
             return increased-initialSalary;

         }


    }




}
