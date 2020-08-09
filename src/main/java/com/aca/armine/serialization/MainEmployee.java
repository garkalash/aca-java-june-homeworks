package com.aca.armine.serialization;

public class MainEmployee {

    public static void main(String[] args) {
        Manager manager = new Manager();
        JsonConverter jsonConverter = new JsonConverter();
        manager.increaseSalary(manager.getOver50EmployeesList(), 10d);
        jsonConverter.writeInJson2(manager, "report.json");
        for (String section : manager.getSectionList()) {
            jsonConverter.writeInJson1(manager.getEmployeesListBySection(section), section.concat(".json"));

        }
       manager.getSortedListByBalance();



    }
}
