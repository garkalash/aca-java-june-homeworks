package com.aca.files;

import com.aca.files.model.FileIsEmptyException;
import com.aca.files.model.SoldItem;
import com.aca.files.utility.JsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.aca.files.model.Car;
import com.aca.files.model.Order;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author: garik
 * @created: 8/8/2020, 9:11 AM
 */
public class SalesService {
    private List<SoldItem> soldItems;

    public SalesService() {
        soldItems = readFromJson();
    }

    public static void main(String[] args) {
            SalesService salesService = new SalesService();
            salesService.read();
    }

    public void read(){
        try (Reader reader = new FileReader(new File("YOUR_PATH"))) {
            List<SoldItem> salesItems = JsonBuilder.GSON_INSTANCE().fromJson(reader, new TypeToken<List<SoldItem>>() {
            }.getType());
            System.out.println(salesItems);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

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

    private List<SoldItem> readFromJson() {
        File file = new File(
                Objects.requireNonNull(SalesService.class.getClassLoader().getResource("car_sales.json")).getFile());
        Gson gson = JsonBuilder.GSON_INSTANCE();
        List<SoldItem> soldItems = null;
        try (Reader reader = new FileReader(file)) {
            soldItems = gson.fromJson(reader, new TypeToken<List<SoldItem>>() {
            }.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }
        Optional<List<SoldItem>> optionalSoldItemsList = Optional.ofNullable(soldItems);
        if (optionalSoldItemsList.isPresent()) {
            return soldItems;
        } else {
            throw new FileIsEmptyException("File is Empty");
        }
    }

    private void writeInJson(List<SoldItem> soldItems, String fileName) {
        File file = new File("src/main/resources/" + fileName);
        Gson gson = JsonBuilder.GSON_INSTANCE();
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(soldItems, new TypeToken<List<SoldItem>>() {
            }.getType(), writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* 1 Get the most expensive sold car*/
    public String getMostExpensiveCar() {
        SoldItem mostExpensiveCar = soldItems.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(SoldItem::getPrice)).get();
        return mostExpensiveCar.getCar().getModel();
    }

    /* 2 Get the cheapest sold car*/
//    Nare

    public String getCheapestCar(){
        return soldItems
                .stream()
                .filter(Objects::nonNull)
                .min((o1, o2) -> (o1.getPrice().compareTo(o2.getPrice()))).get().getCar().getModel();

    }

    /* 4 Get the weakest sold car*/
    public Integer getWeakestSoldCar() {
        Car mostExpensiveCar;
        mostExpensiveCar = soldItems.stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(soldItem -> soldItem.getCar().getHp()))
                .get().getCar();
        return mostExpensiveCar.getHp();
    }

    /* 6 Get the newest year*/
    public LocalDateTime getLastSellingDate() {
        return soldItems.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(SoldItem::getSoldDate)).get().getSoldDate();
    }

    /* 7 what is our profit if
     * 1500 - 3000 - 1%
     * 3001 - 6000 - 1.2%
     * 6001 - 10000 - 1.5%
     * 10001 - 13000 - 1.7%
     * 13000 - 15000 - 1.8%
     */
//    Nare

    public BigDecimal changedProfit(){

    Double profit =soldItems
            .stream()
            .mapToDouble(value -> {
                BigDecimal price = value.getPrice();
                BigDecimal sum = BigDecimal.ZERO;

                if(price.compareTo(BigDecimal.valueOf(1500))>0 && price.compareTo( BigDecimal.valueOf( 3000 )) < 0 ){
                    sum = sum.add(price.multiply(BigDecimal.valueOf(1/100))) ;
                }
                else if (price.compareTo(BigDecimal.valueOf(3001))>0 && price.compareTo( BigDecimal.valueOf( 6000 )) < 0 ){
                    sum = sum.add(price.multiply(BigDecimal.valueOf(1.2/100))) ;

                }
                else if (price.compareTo(BigDecimal.valueOf(6001))>0 && price.compareTo( BigDecimal.valueOf( 10000 )) < 0 ){
                    sum = sum.add(price.multiply(BigDecimal.valueOf(1.5/100))) ;

                }
                else if (price.compareTo(BigDecimal.valueOf(10001))>0 && price.compareTo( BigDecimal.valueOf( 13000 )) < 0 ){
                    sum = sum.add(price.multiply(BigDecimal.valueOf(1.7/100))) ;

                }
                else if (price.compareTo(BigDecimal.valueOf(13001))>0 && price.compareTo( BigDecimal.valueOf( 15000 )) < 0 ){
                    sum = sum.add(price.multiply(BigDecimal.valueOf(1.8/100))) ;

                }
                return sum.doubleValue();}).sum();

        return BigDecimal.valueOf(profit);
    }

    /* 8 group by model count*/
    public Map<String, List<SoldItem>> groupByModelCount() {
        return soldItems.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(soldItem -> soldItem.getCar().getModel()));
    }


    /* 11 given model return list of items*/
    public List<SoldItem> getItemsListByModel(String model) {
        return soldItems.stream()
                .filter(Objects::nonNull)
                .filter(soldItem -> soldItem.getCar().getModel().equals(model))
                .collect(Collectors.toList());
    }

    /* 12 given year range return list of items*/
    public List<SoldItem> listOfItemsByYearRange(int from, int to) {
        return soldItems.stream()
                .filter(Objects::nonNull)
                .filter(soldItem -> soldItem.getCar().getCarYear() > from)
                .filter(soldItem -> soldItem.getCar().getCarYear() < to)
                .collect(Collectors.toList());

    }


    /* 16
     */
    public void writeSoldItemsInFileByModel() {
        List<String> carModels = soldItems.stream()
                .map(soldItem -> soldItem.getCar().getModel())
                .distinct()
                .collect(Collectors.toList());
        for (String carModel : carModels) {
            List<SoldItem> list = getItemsListByModel(carModel);
            writeInJson(list,carModel.concat(".json"));
        }

    }
    private Car oldestYearCar() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/main/resources/car_sales.json");
        JSONArray orders = (JSONArray) jsonParser.parse(fileReader);
        List<Order> orderList = new ArrayList<>();
        return null;
    }
}

