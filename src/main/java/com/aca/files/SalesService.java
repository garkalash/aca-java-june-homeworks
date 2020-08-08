package com.aca.files;

import com.aca.files.model.FileIsEmptyException;
import com.aca.files.model.SalesItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

    public List<SalesItem> convertFromJson() {
        File file = new File(
                Objects.requireNonNull(SalesService.class.getClassLoader().getResource("car_sales.json")).getFile());
        Gson gson = new Gson();
        List<SalesItem>   salesItems = null;
         try (Reader reader = new FileReader(file)) {
        salesItems = gson.fromJson(reader, new TypeToken<List<SalesItem>>() {
            }.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }
        Optional<List<SalesItem>> optionalSalesItemsList = Optional.ofNullable(salesItems);
         if(optionalSalesItemsList.isPresent()){
             return salesItems;
         }else {
             throw new FileIsEmptyException("File is Empty");
         }
    }

    /* 1 Get the most expensive sold car*/
    public String getMostExpensiveCar(List<SalesItem> salesItems) {
        SalesItem mostExpensiveCar = salesItems.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(salesItem -> Double.parseDouble((salesItem.getPrice()).replaceAll("[^0-9.]", "")))).get();
        return mostExpensiveCar.getCar().getModel();

    }

    /* 6 Get the newest year*/
    public String getLastSellingDate(List<SalesItem> salesItems) {
        SalesService salesService = new SalesService();
        return salesItems.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(salesItem -> salesService.convertStringToDate(salesItem.getSoldDate()))).get().getSoldDate();

    }

    public Date convertStringToDate(String dateByString) {
        dateByString = dateByString.replaceAll("[A-Z]", " ");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return formatter.parse(dateByString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /* 11 given model return list of items*/
    public List<SalesItem> getItemsListByModel(String model) {
        SalesService salesService = new SalesService();
        List<SalesItem> salesItems = salesService.convertFromJson();
        return salesItems.stream()
                .filter(Objects::nonNull)
                .filter(salesItem -> salesItem.getCar().getModel().equals(model))
                .collect(Collectors.toList());
    }

}
