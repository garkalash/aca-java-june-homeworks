package com.aca.files;

import com.aca.armine.serialization.Employee;
import com.aca.files.model.Car;
import com.aca.files.model.SalesItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: garik
 * @created: 8/8/2020, 9:11 AM
 */
public class SalesService {

    /* 1 Get the most expensive sold car*/
    /* 2 Get the cheapest sold car*/
    /* 3 Get the strongest sold car*/
    /* 4 Get the weakest sold car*/
    /* 5 Get the oldest year*/
    /* 6 Get the newest year*/

    /* 7 what is our profit if
    * 1500 - 3000 - 1%
    * 3001 - 6000 - 1.2%
    * 6001 - 10000 - 1.5%
    * 10001 - 13000 - 1.7%
    * 13000 - 15000 - 1.8%
    */

    /* 8 group by model count*/
    /* 9 group by defects count - sold count*/
    /* 10 group by by range*/

    /* 11 given model return list of items*/
    /* 12 given year range return list of items*/
    /* 13 given price range return list of items*/
    /* 14 given power range return list of items*/
    /* 15 given power range return list of items*/

    public List<SalesItem> convertFromJson(String jsonFilePath) {
        Path path = Paths.get(jsonFilePath);
        Gson gson = new Gson();
        File file = path.toFile();
        List<SalesItem> salesItems = null;
        try (Reader reader = new FileReader(file)) {
           salesItems = gson.fromJson(reader, new TypeToken<List<SalesItem>>() {
            }.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return salesItems;
    }
    public Car getMostExpensiveCar (List<SalesItem> salesItems) {
        Map<Car, Double> carListByPrice = salesItems.stream()
                .collect(Collectors.toMap(SalesItem::getCar, salesItem -> Double.parseDouble((salesItem.getPrice()).replaceAll("[^0-9.]", ""))));
        return carListByPrice.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();

    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/car_sales.json");
        SalesService salesService = new SalesService();
        List<SalesItem> salesItems =  salesService.convertFromJson(path.toString());

        System.out.println( salesService.getMostExpensiveCar(salesItems).getModel());


    }


}