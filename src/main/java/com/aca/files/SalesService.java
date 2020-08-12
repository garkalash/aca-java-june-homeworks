package com.aca.files;

import com.aca.files.model.*;
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
    private final List<SoldItem> soldItems;

    public SalesService() {
        soldItems = readFromJson();
    }

    public static void main(String[] args) {
            SalesService salesService = new SalesService();
            salesService.read();
            List<Pair> priceRanges = new ArrayList<>();
            Pair range1 = new Pair(1500,3000);
            Pair range2 = new Pair(3001,6000);
            Pair range3 = new Pair(6001,10000);
            Pair range4 = new Pair(10001,13000);
            Pair range5 = new Pair(10001,15000);
            priceRanges.add(range1);
            priceRanges.add(range2);
            priceRanges.add(range3);
            priceRanges.add(range4);
            priceRanges.add(range5);
        System.out.println(salesService.groupByPriceRange(priceRanges));
    }

    public void read(){
        try (Reader reader = new FileReader(new File("src/main/resources/car_sales.json"))) {
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
                .min(Comparator.comparing(SoldItem::getPrice)).get().getCar().getModel();

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

    /* 5 Get the oldest year*/
    public LocalDateTime getOldestYearofSale() {
        Optional<LocalDateTime> oldestYearOfSale = soldItems.stream()
                .map(SoldItem::getSoldDate)
                .min(Comparator.comparing(soldDate->soldDate));
        return oldestYearOfSale.orElseGet(this::getOldestYearofSale);
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
    public BigDecimal getProfit(){
        Double profit =soldItems
                .stream()
                .mapToDouble(value -> {
                    BigDecimal price = value.getPrice();
                    Reward reward = new Reward();
                    return reward.profitCalculator(price);
                })
                .sum();

        return BigDecimal.valueOf(profit);
    }

    /* 8 group by model count*/
    public Map<String, List<SoldItem>> groupByModelCount() {
        return soldItems.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(soldItem -> soldItem.getCar().getModel()));
    }
    /* 10 group by by range*/
    public Map<String, List<Car>> groupByPriceRange (List<Pair> priceRanges) {
       Map<String, List<Car>> grouppedByPriceCars = new HashMap<>();
       List<Car> grouppedCars;
        for (Pair range : priceRanges) {
               grouppedCars = soldItems.stream()
                .filter(soldItem -> soldItem.getPrice().intValue() > range.getFrom() && soldItem.getPrice().intValue() < range.getTo())
                    .map(SoldItem::getCar)
                .collect(Collectors.toList());
                 grouppedByPriceCars.put(range.toString(), grouppedCars);
        }
        return grouppedByPriceCars;
    }

    /* 11 given model return list of items*/
    public List<SoldItem> getItemsListByModel(String model) {
        return soldItems.stream()
                .filter(Objects::nonNull)
                .filter(soldItem -> soldItem.getCar().getModel().equals(model))
                .collect(Collectors.toList());
    }

    /* 12 given year range return list of items*/
//    Nare
    public List<SoldItem> getSoldItemsByYearRange(Integer startYear, Integer endYear){
        return soldItems
                .stream()
                .filter(Objects::nonNull)
                .filter(soldItem -> (soldItem.getCar().getCarYear()>=startYear) && (soldItem.getCar().getCarYear() <= endYear))
                .collect(Collectors.toList());
    }

    /* 15 given power range return list of items*/
    public List<Car> itemsByPowerRange(String range) {
        range = range.trim();
        String rangeFrom = range.split("-")[0];
        String rangeTo = range.split("-")[1];
        return soldItems.stream()
                .filter(Objects::nonNull)
                .map(SoldItem::getCar)
                .filter(car->car.getHp() >= Integer.parseInt(rangeFrom) && car.getHp() <= Integer.parseInt(rangeTo))
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
    // get Json String of solditems per defects count

    public Map<Integer, String> getJsonStringByDefects(){
        Map<Integer,List<SoldItem>> soldItemsByDefect = soldItems
                .stream()
                .collect(Collectors
                        .groupingBy(soldItem -> soldItem.getCar().getDefects().size(),Collectors.toList()));


        return soldItemsByDefect
                .entrySet()
                .stream()
                .collect(Collectors.toMap(o -> o.getKey(), o -> JsonBuilder.GSON_INSTANCE().toJson(o.getValue())));


    }
}

