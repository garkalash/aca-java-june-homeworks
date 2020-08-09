package com.aca.armine.serialization;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Manager {

    private List<Employee> employees;

    public Manager() {
        JsonConverter jsonConverter = new JsonConverter();
        employees = jsonConverter.readFromJson();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    private BigDecimal getEmployeeOldSalarySum(List<Employee> employeeList) {
        return employeeList.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getEmployeeNewSalarySum(List<Employee> employeeList) {
        return employeeList.stream()
                .map(Employee::getNewSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public List<Employee> getOver50EmployeesList() {
        return employees.stream()
                .filter(Objects::nonNull)
                .filter(employee -> employee.getAge() > 50)
                .collect(Collectors.toList());
    }


    public void increaseSalary(List<Employee> employeesNewList, Double percent) {
        employeesNewList
                .forEach(employee -> employee.setNewSalary(employee.getSalary().add(employee.getSalary().multiply(BigDecimal.valueOf(percent / 100)))));
        employees.stream()
                .filter(Objects::nonNull)
                .filter(employee -> employee.getNewSalary().equals(new BigDecimal(0)))
                .forEach(employee -> employee.setNewSalary(employee.getSalary()));

    }

    public Map<String, Long> getEmployeesCountBySection(List<Employee> employeeList) {
        return employeeList.stream()
                .map(Employee::getSection)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

    }


    public Map<String, List<Employee>> getEmployeesMaptBySection(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(Objects::nonNull)
                .map(Employee::getSection)
                .distinct()
                .collect(Collectors.toMap(s -> s, s -> employeeList.stream()
                        .filter(employee -> employee.getSection().equals(s))
                        .collect(Collectors.toList())));
    }

    public String getTheMostAffectedSection() {
        Map<String, BigDecimal> newMap = getEmployeesMaptBySection(employees).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, stringListEntry ->
                        getEmployeeNewSalarySum(stringListEntry.getValue()).subtract(getEmployeeOldSalarySum(stringListEntry.getValue()))));
        return newMap.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();

    }

    public BigDecimal getMoneyForSalaryIncrease() {
        return getEmployeeNewSalarySum(employees).subtract(getEmployeeOldSalarySum(employees));
    }

    public BigDecimal getIncreasedSalaryAverage() {
        return getOver50EmployeesList().stream()
                .map(employee -> employee.getNewSalary().subtract(employee.getSalary()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(getOver50EmployeesList().size()), RoundingMode.HALF_EVEN);
    }

    public Employee getEmployeeWithMaxIncreased() {
        return getOver50EmployeesList().stream()
                .max(Comparator.comparing(employee -> employee.getNewSalary().subtract(employee.getSalary()))).get();
    }

    public Employee getEmployeeWithMinIncreased() {
        return getOver50EmployeesList().stream()
                .min(Comparator.comparing(employee -> employee.getNewSalary().subtract(employee.getSalary()))).get();
    }

    public List<Employee> getEmployeesListBySection(String section) {
        return employees.stream()
                .filter(Objects::nonNull)
                .filter(employee -> employee.getSection().equals(section))
                .collect(Collectors.toList());
    }

    public List<String> getSectionList() {
        return employees.stream()
                .map(Employee::getSection)
                .distinct()
                .collect(Collectors.toList());

    }

    public List<Employee> getSortedListByBalance() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getBalance).reversed().thenComparing(Employee::getSalary))
                .collect(Collectors.toList());

    }


}
