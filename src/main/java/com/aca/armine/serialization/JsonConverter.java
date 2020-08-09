package com.aca.armine.serialization;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class JsonConverter {


    public List<Employee> readFromJson() {
        File file = new File(
                Objects.requireNonNull(Manager.class.getClassLoader().getResource("employees.json")).getFile());
        Gson gson = JsonBuilderEmployee.GSON_INSTANCE();
        List<Employee> employees = null;
        try (Reader reader = new FileReader(file)) {
            employees = gson.fromJson(reader, new TypeToken<List<Employee>>() {
            }.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }
        Optional<List<Employee>> optionalSoldItemsList = Optional.ofNullable(employees);
        if (optionalSoldItemsList.isPresent()) {
            return employees;
        } else {
            throw new FileContentException("File is Empty");
        }
    }

    public void writeInJson1(List<Employee> employees, String fileName) {
        File file = new File("src/main/resources/" + fileName);
        Gson gson = JsonBuilderEmployee.GSON_INSTANCE1();
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(employees, new TypeToken<List<Employee>>() {
            }.getType(), writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeInJson2(Manager manager, String fileName) {
        File file = new File("src/main/resources/" + fileName);
        Gson gson = JsonBuilderEmployee.GSON_INSTANCE2();
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(manager, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
