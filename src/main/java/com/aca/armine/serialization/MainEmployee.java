package com.aca.armine.serialization;


public class MainEmployee {

    public static void main(String[] args) {
        Manager manager = new Manager();
        //task1
        manager.increaseSalary( 10d, employee -> (employee.getAge() > 50));
        //task2
        manager.getJsonConverter().writeInJson2(manager, "report.json");
        //task3
        for (String section : manager.getSectionList()) {
            manager.getJsonConverter()
                    .writeInJson1(manager.getEmployeesListBySection(section), section.concat(".json"));

        }
       manager.getSortedListByBalance();


    }
}
