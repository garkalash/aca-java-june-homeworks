package com.aca.armine.serialization;

import com.google.gson.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonBuilderEmployee {

    public static Gson GSON_INSTANCE() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<Employee> deserializer = (json, typeOfT, context) -> {
            JsonObject jsonObject = json.getAsJsonObject();
            String id = jsonObject.get("_id").getAsString();
            Integer index =jsonObject.get("index").getAsInt();
            BigDecimal balance = new BigDecimal(jsonObject.get("balance").getAsString().replaceAll("[^0-9.]", ""));
            BigDecimal salary = new BigDecimal(jsonObject.get("salary").getAsString().replaceAll("[^0-9.]", ""));
            Integer age = jsonObject.get("age").getAsInt();
            String email = jsonObject.get("email").getAsString();
            String phone = jsonObject.get("phone").getAsString();
            LocalDateTime birthDate = LocalDateTime.parse(jsonObject.get("birthdate").getAsString().replace( " -04:00", ""));
            String section = jsonObject.get("section").getAsString();

            Employee employee = new Employee();
            employee.setId(id);
            employee.setIndex(index);
            employee.setBalance(balance);
            employee.setSalary(salary);
            employee.setAge(age);
            employee.setEmail(email);
            employee.setPhone(phone);
            employee.setBirthDate(birthDate);
            employee.setSection(section);
            return employee;
        };
        gsonBuilder.registerTypeAdapter(Employee.class, deserializer);

        return gsonBuilder.create();
    }

    public static Gson GSON_INSTANCE1() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        JsonSerializer<Employee> serializer = (employee, type, jsonSerializationContext) -> {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", employee.getId());
            jsonObject.addProperty("index",employee.getIndex());
            jsonObject.addProperty("balance", employee.getBalance().toString().concat(" USD"));
            jsonObject.addProperty("salary", employee.getNewSalary().toString().concat(" USD"));
            jsonObject.addProperty("age", employee.getAge());
            jsonObject.addProperty("email", employee.getEmail());
            jsonObject.addProperty("phone", employee.getPhone());
            jsonObject.addProperty("birthDate", employee.getBirthDate().format(DateTimeFormatter.ISO_DATE_TIME));
            jsonObject.addProperty("section", employee.getSection());
            return jsonObject;

        };
        gsonBuilder.registerTypeAdapter(Employee.class, serializer);

        return gsonBuilder.create();
    }
    public static Gson GSON_INSTANCE2() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        JsonSerializer<Manager> serializer = (manager, type, jsonSerializationContext) -> {
            Gson gson = new Gson();

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Employees count by section", gson.toJson(manager.getEmployeesCountBySection(manager.getEmployees())));
            jsonObject.addProperty("Over 50 employees count by section",gson.toJson(manager.getEmployeesCountBySection(manager.getOver50EmployeesList())));
            jsonObject.addProperty("Money for salary increasing", gson.toJson(manager.getMoneyForSalaryIncrease().toString().concat(" USD")));
            jsonObject.addProperty("The most affected section ", gson.toJson(manager.getTheMostAffectedSection()));
            jsonObject.addProperty("Increased salary average",gson.toJson(manager.getIncreasedSalaryAverage().toString().concat(" USD")));
            jsonObject.add("Employee with Max increased salary", GSON_INSTANCE1().toJsonTree(manager.getEmployeeWithMaxIncreased()));
            jsonObject.add("Employee with Min increased salary", GSON_INSTANCE1().toJsonTree(manager.getEmployeeWithMinIncreased()));
            return jsonObject;

        };
        gsonBuilder.registerTypeAdapter(Manager.class, serializer);

        return gsonBuilder.create();
    }


}
