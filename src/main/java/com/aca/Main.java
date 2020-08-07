package com.aca;

import com.aca.streams.employeesJson.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello students!");

        JSONParser jsonParser = new JSONParser();
        List<Employee> employees = new ArrayList<>();
        try (FileReader reader = new FileReader("src\\main\\resources\\employees.json")) {
            JSONArray employeeList = (JSONArray) jsonParser.parse(reader);
            employeeList.forEach(employee -> employees.add(initNewEmployee((JSONObject)employee)));
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }

        collectReport(employees);
        employeeAfterRise(employees);
        divideEmployeeJsonToSeparateFile(employees);
    }

    /*
     * Task 1
     */
    public static List<Employee> employeeAfterRise(List<Employee> employees) {
        return employees.stream()
                .peek(employee -> {
                    if (employee.getAge() > 50)
                        employee.setSalary(("$" + (Double.parseDouble(employee.getSalary().replace("$", "").replaceAll(",", "")) * 110 / 100)));
                })
                .collect(Collectors.toList());
    }

    public static void collectReport(List<Employee> employees) {
        employeesBySectionAndAgeReport(employees);
        mostAffectedSection(employees);
        maxIncreaseEmployee(employees);
        minIncreaseEmployee(employees);
    }

    /*
     * Task 2.1, 2.2, 2.4
     */
    public static void employeesBySectionAndAgeReport(List<Employee> employees) {
        Map<String, Integer> stringLongMap = new HashMap<>();

        for (Employee employee : employees) {
            if (stringLongMap.containsKey(employee.getSection()))
                stringLongMap.put(employee.getSection(), stringLongMap.get(employee.getSection()) + 1);
            else {
                stringLongMap.put(employee.getSection(), 1);
            }
        }

        try (FileWriter file = new FileWriter("src\\main\\resources\\report.json")) {
            for (String section : stringLongMap.keySet()) {
                JSONObject report = new JSONObject();
                report.put("Section", section);
                report.put("Total workers", stringLongMap.get(section));
                report.put("Older than 50", employees.stream().filter(employee -> employee.getSection().equals(section)).map(Employee::getAge).filter(age -> age > 50).count());
                report.put("Total spend for raise", "$" + employees.stream()
                        .filter(employee -> employee.getSection().equals(section))
                        .filter(employee -> employee.getAge() > 50)
                        .map(employee -> (Double.parseDouble(employee.getSalary().replace("$", "").replaceAll(",", "")) * 110 / 100) -
                                (Double.parseDouble(employee.getSalary().replace("$", "").replaceAll(",", ""))))
                        .reduce((double) 0, Double::sum));
                report.put("Average rise", "$" + employees.stream()
                        .filter(employee -> employee.getSection().equals(section))
                        .filter(employee -> employee.getAge() > 50)
                        .map(employee -> (Double.parseDouble(employee.getSalary().replace("$", "").replaceAll(",", "")) * 110 / 100) -
                                (Double.parseDouble(employee.getSalary().replace("$", "").replaceAll(",", ""))))
                        .reduce((double) 0, Double::sum) / employees.stream().filter(employee -> employee.getSection().equals(section))
                                                                    .filter(employee -> employee.getAge() > 50)
                                                                    .count());
                file.write(report.toJSONString());
                file.write(",\n");
                file.flush();
            }
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Task 2.3
     */
    public static void mostAffectedSection(List<Employee> employees) {
        try (FileWriter file = new FileWriter("src\\main\\resources\\report.json", true)) {
            Set<String> sections = employees.stream()
                    .map(employee -> employee.getSection())
                    .collect(Collectors.toSet());

            Map<String, Double> costs = new HashMap<>();
            sections.forEach(section -> {
                costs.put(section, employees.stream()
                        .filter(employee -> employee.getSection().equals(section))
                        .filter(employee -> employee.getAge() > 50)
                        .map(employee -> Double.parseDouble(employee.getSalary().replace("$", "").replaceAll(",", "")) * 10 / 100)
                        .reduce((double) 0, Double::sum));
            });

            JSONObject report = new JSONObject();
            String mostCostly = "";
            Double maxCost = Double.MIN_VALUE;
            for (String section : costs.keySet()) {
                if (maxCost < costs.get(section)) {
                    maxCost = costs.get(section);
                    mostCostly = section;
                }
            }
            file.write("{");
            report.put("Most costly section", mostCostly);
            file.write(report.toJSONString());
            file.write("}\n");
            file.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Task 2.5
     */
    public static void maxIncreaseEmployee(List<Employee> employees) {
        try (FileWriter file = new FileWriter("src\\main\\resources\\report.json", true)) {
            Optional<Employee> maxSalaryIncreaseEmployee = employees.stream()
                    .filter(employee -> employee.getAge() > 50)
                    .max((emp1, emp2) -> (int) (Double.parseDouble(emp1.getSalary().replace("$", "").replaceAll(",", "")) -
                                                Double.parseDouble(emp2.getSalary().replace("$", "").replaceAll(",", ""))));
            JSONObject report = new JSONObject();
            report.put("Maximum salary increase", maxSalaryIncreaseEmployee);
            file.write(report.toJSONString());
            file.write("\n");
            file.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Task 2.6
     */
    public static void minIncreaseEmployee(List<Employee> employees) {
        try (FileWriter file = new FileWriter("src\\main\\resources\\report.json", true)) {
            Optional<Employee> maxSalaryIncreaseEmployee = employees.stream()
                    .filter(employee -> employee.getAge() > 50)
                    .min((emp1, emp2) -> (int) (Double.parseDouble(emp1.getSalary().replace("$", "").replaceAll(",", "")) -
                            Double.parseDouble(emp2.getSalary().replace("$", "").replaceAll(",", ""))));
            JSONObject report = new JSONObject();
            report.put("Minimum salary increase", maxSalaryIncreaseEmployee);
            file.write(report.toJSONString());
            file.write("\n");
            file.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Task 3
     */
    public static void divideEmployeeJsonToSeparateFile(List<Employee> employees) {
        Set<String> sections = employees.stream()
                .map(employee -> employee.getSection())
                .collect(Collectors.toSet());
        sections.forEach(section -> {
            try (FileWriter file = new FileWriter("src\\main\\resources\\" + section + ".json", true)) {
                List<Employee> empList = new ArrayList<>();
                empList = employees.stream()
                        .filter(employee -> employee.getSection().equals(section))
                        .collect(Collectors.toList());
                file.write(empList.toString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    private static Employee initNewEmployee(JSONObject employee) {
        return new Employee((String) employee.get("_id"), (Long) employee.get("index"), (String) employee.get("balance"),
                (String) employee.get("salary"), (Long) employee.get("age"), (String) employee.get("email"),
                (String) employee.get("phone"), (String) employee.get("birthdate"), (String) employee.get("section"));
    }
}
