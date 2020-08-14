package com.aca.armine.serialization;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Manager {

    private final List<Employee> employees;
    private final JsonConverter jsonConverter;
    private final List<Employee> employeesUnchangedList;

    public Manager() {
        jsonConverter = new JsonConverter();
        employeesUnchangedList = jsonConverter.readFromJson();
        employees = jsonConverter.readFromJson();
    }

    public JsonConverter getJsonConverter() {
        return jsonConverter;
    }


    private List<Employee> getOver50EmployeesList() {
        return employees.stream()
                .filter(Objects::nonNull)
                .filter(employee -> employee.getAge() > 50)
                .collect(Collectors.toList());
    }

    public void increaseSalary(Double percent, Predicate<Employee> predicate) {
        employees.stream()
                .filter(Objects::nonNull)
                .filter(predicate)
                .forEach(employee -> employee.setSalary(employee.getSalary()
                        .add(employee.getSalary().multiply(BigDecimal.valueOf(percent / 100)))));
    }

    private BigDecimal getEmployeeSalarySum(List<Employee> employeeList) {
        return employeeList.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<String, Long> getEmployeesCountBySection(Predicate<Employee> predicate) {
        return employees.stream()
                .filter(predicate)
                .map(Employee::getSection)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    public String getTheMostAffectedSection() {
        Map<String, BigDecimal> salaryDifferenceMap = new HashMap<>();
        for (String s : getSectionList()) {
            BigDecimal salaryAfterIncreasing = employees.stream()
                    .filter(employee -> employee.getSection().equals(s))
                    .map(Employee::getSalary)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal salaryBeforeIncreasing = employeesUnchangedList.stream()
                    .filter(employee -> employee.getSection().equals(s))
                    .map(Employee::getSalary)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            salaryDifferenceMap.put(s, salaryAfterIncreasing.subtract(salaryBeforeIncreasing));
        }
        Optional<Map.Entry<String, BigDecimal>> theMostAffectedSection = salaryDifferenceMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        if (theMostAffectedSection.isPresent()) {
            return theMostAffectedSection.get().getKey();
        } else {
            return "There isn't the most affected section";
        }
    }

    public BigDecimal getMoneyForSalaryIncrease() {
        return getEmployeeSalarySum(employees).subtract(getEmployeeSalarySum(employeesUnchangedList));
    }

    public BigDecimal getIncreasedSalaryAverage() {
        return employees.stream()
                .map(employee -> employee.getSalary().subtract(employeesUnchangedList.stream()
                        .filter(employee1 -> employee1.getIndex().equals(employee.getIndex()))
                        .findAny()
                        .get().getSalary()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(getOver50EmployeesList().size()), RoundingMode.HALF_EVEN);
    }

    public Employee getEmployeeWithMaxIncreased() {
        Optional<Employee> optionalEmployee = getOver50EmployeesList().stream()
                .max(Comparator.comparing(employee -> employee.getSalary().subtract(employeesUnchangedList.stream()
                        .filter(employee1 -> employee1.getIndex().equals(employee.getIndex()))
                        .findAny()
                        .get().getSalary())));

        return optionalEmployee.orElse(null);
    }

    public Employee getEmployeeWithMinIncreased() {
        Optional<Employee> optionalEmployee = getOver50EmployeesList().stream()
                .min(Comparator.comparing(employee -> employee.getSalary().subtract(employeesUnchangedList.stream()
                        .filter(employee1 -> employee1.getIndex().equals(employee.getIndex()))
                        .findAny()
                        .get().getSalary())));
        return optionalEmployee.orElse(null);
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
