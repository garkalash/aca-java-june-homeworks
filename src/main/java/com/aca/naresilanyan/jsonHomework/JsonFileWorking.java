package com.aca.naresilanyan.jsonHomework;

import org.json.JSONObject;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonFileWorking {
    public static void main(String[] args) {

        Path path = Paths.get("/Users/ns/workspace/aca-java-june-homeworks/src/main/resources/employees.json");
        String regex = "";
        Pattern p = Pattern.compile(regex);
        List<String> strings = new ArrayList<>();



        try {

            List<String> objects = new ArrayList<>();

              List<String>  jsonstrings =  Files.readAllLines(Paths.get(String.valueOf(path)));
              String string = "";
//              string = string + "b";
//            System.out.println(string);


              for(int i = 0; i< jsonstrings.size(); i++){
                  if(jsonstrings.get(i).contains("{")){
                      string = string + jsonstrings.get(i);

                      for(int j = i+1; j<jsonstrings.size(); j ++){
                          if(jsonstrings.get(j).contains("}")){
                              string = string + jsonstrings.get(j);
                              objects.add(string);
                              string ="";
                              break;


                          }else {
                              string = string + jsonstrings.get(j);

                          }

                      }
//                      System.out.println(k.get(i));
                  }
              }

              for (int i = 0; i < objects.size(); i ++){
                  strings.add(objects.get(i).substring(0, objects.get(i).length() - 1));
              }



           } catch (IOException e) {
               e.printStackTrace();
           }

        List<Employee> employees = new ArrayList<>();

        for(int i = 0; i < strings.size()-1; i ++){
            JSONObject jsonObject = new JSONObject(strings.get(i));

            Employee employee = new Employee();
            employee.setAge(jsonObject.getInt("age"));
            employee.setBalance(Double.parseDouble(jsonObject.getString("balance").substring(1,jsonObject.getString("balance").length()).replace(",","")));
            employee.setSalary(Double.parseDouble(jsonObject.getString("salary").substring(1,jsonObject.getString("salary").length()).replace(",","")));
            employee.setId(jsonObject.getString("_id"));
            employee.setIndex(jsonObject.getInt("index"));
            employee.setEmail(jsonObject.getString("email"));
            employee.setPhone(jsonObject.getString("phone"));
            employee.setBirthdate(jsonObject.getString("birthdate"));
            employee.setSection(jsonObject.getString("section"));
            employees.add(employee);

        }

        Manager manager = new Manager();

//      1
        manager.increaseSalary(10,employees);


//        2.1
        System.out.println(manager.countEmployeePerSection(employees));
        System.out.println(manager.countEmployeesgreater50(employees));

//       2.2
        System.out.println(manager.companyExpanses(employees));


    }
}
