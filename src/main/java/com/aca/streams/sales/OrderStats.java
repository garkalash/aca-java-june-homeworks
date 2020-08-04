package com.aca.streams.sales;

import com.aca.streams.models.*;

import javax.swing.text.html.Option;
import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class provides several methods to collect statistical information from customers and orders of an e-shop.
 * Your task is to implement methods of this class using Java 8 Stream API.
 * Each method is covered with a number of unit tests. You can use <code>mvn test</code> call to check your implementation.
 *
 * Refer to the <code>com.expertsoft.model</code> package to observe the domain model of the shop.
 */
class OrderStats {
    public static void main(String[] args) {

    }


    /**
     * Task 1 (⚫⚫⚪⚪⚪)
     *
     * Given a stream of customers, return the list of orders, paid using provided credit card type (Visa or MasterCard).
     *
     * @param customers stream of customers
     * @param cardType credit card type
     * @return list, containing orders paid with provided card type
     */
    static List<Order> ordersForCardTypeNare(final Stream<Customer> customers, PaymentInfo.CardType cardType) {
        List<Order> orders = new ArrayList<>();
        customers.forEach(customer -> {
           customer.getOrders().stream().forEach(order -> {
               if (order.getPaymentInfo().getCardType() == cardType){
                   orders.add(order);
               };});
        });
        return orders;
    }

    static List<Order> ordersForCardType_Armine(final Stream<Customer> customers, PaymentInfo.CardType cardType) {
        return customers
                .map(Customer::getOrders)
                .flatMap(Collection::stream)
                .filter(order -> order.getPaymentInfo().getCardType() == cardType)
                .collect(Collectors.toList());

    }

    static List<Order> ordersForCardType_Narek(final Stream<Customer> customers, PaymentInfo.CardType cardType) {
        List<Order> orderList = customers
                .filter(Objects::nonNull)
                .map(Customer::getOrders)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(order -> order.getPaymentInfo().getCardType() == cardType)
                .collect(Collectors.toList());
        return orderList;
    }

    static List<Order> ordersForCardType_Arsen(final Stream<Customer> customers, PaymentInfo.CardType cardType) {
        return customers
                .map(Customer::getOrders)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(order -> order.getPaymentInfo().getCardType() == cardType)
                .collect(Collectors.toList());
    }

    static List<Order> ordersForCardType_Raf(final Stream<Customer> customers, PaymentInfo.CardType cardType) {
        return customers
                .map(Customer::getOrders)
                .flatMap(Collection::stream)
                .filter(order -> order.getPaymentInfo().getCardType() == cardType)
                .collect(Collectors.toList());
    }

    /**
     * Task 2 (⚫⚫⚪⚪⚪)
     *
     * Given a stream of orders, return a map, where keys are different order sizes and values are lists of orders,
     * referring to this sizes. Order size here is just a total number of products in the order.
     *
     * @param orders stream of orders
     * @return map, where order size values mapped to lists of orders
     */

    static Map<Integer, List<Order>> orderSizes_Narek(final Stream<Order> orders) {

        Map<Integer, List<Order>> integerListMap = orders
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(order -> Math.toIntExact(order.getOrderItems().stream()
                        .map(orderItem -> orderItem.getQuantity())
                        .reduce(0, Integer::sum)), Collectors.toList()));

        return integerListMap;
    }

    static Map<Integer, List<Order>> orderSizes_Armine(final Stream<Order> orders) {
        return orders
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(order -> (order.getOrderItems().stream()
                        .map(OrderItem::getQuantity)
                        .reduce(0, Integer::sum)), Collectors.toList()));
    }

    static Map<Integer, List<Order>> orderSizes_Arsen (final Stream<Order> orders) {
        return orders.collect(Collectors.groupingBy((quantity -> quantity.getOrderItems().stream()
                .filter(Objects::nonNull)
                .map(OrderItem::getQuantity).reduce(0, Integer::sum)), Collectors.toList()));
    }
    static Map<Integer, List<Order>> orderSizesNare(final Stream<Order> orders) {

        Map<Integer,List<Order>> ordersBySize =orders.filter(Objects::nonNull).collect(Collectors.groupingBy(order -> order.getOrderItems().stream().collect(Collectors.summingInt(OrderItem::getQuantity)),Collectors.toList()));
        return ordersBySize;
    }





    /**
     * Task 3 (⚫⚫⚫⚪⚪)
     *
     * Given a stream of orders, return true only if EVERY order in the stream contains at least
     * one product of the provided color and false otherwise.
     *
     * @param orders stream of orders
     * @param color product color to test
     * @return boolean, representing if every order in the stream contains product of specified color
     */


    static Boolean hasColorProduct_Narek(final Stream<Order> orders, final Product.Color color) {

        return orders.allMatch(order -> order.getOrderItems()
                .stream()
                .anyMatch(orderItem -> orderItem.getProduct().getColor() == color));
    }
    static Boolean hasColorProduct_Armine(final Stream<Order> orders, final Product.Color color) {
        return orders
                .allMatch(order -> order.getOrderItems().stream()
                        .anyMatch(orderItem -> orderItem.getProduct().getColor() == color));
    }


    static Boolean hasColorProduct_Arsen(final Stream<Order> orders, final Product.Color color) {
        return orders.allMatch(order -> order.getOrderItems().stream()
                .anyMatch(product ->product.getProduct().getColor().equals(color)));
    }

    static Boolean hasColorProductNare(final Stream<Order> orders, final Product.Color color) {

        return orders.filter(Objects::nonNull).allMatch(order -> order.getOrderItems().stream().anyMatch(orderItem -> orderItem.getProduct().getColor() == color
        ));

    }







    /**
     * Task 4 (⚫⚫⚫⚫⚪)
     *
     * Given a stream of customers, return the map, where customer email is mapped to a number of different credit cards he/she used by the customer.
     *
     * @param customers stream of customers
     * @return map, where for each customer email there is a long referencing a number of different credit cards this customer uses.
     */

    static Map<String, Long> cardsCountForCustomer_Narek(final Stream<Customer> customers) {
        return customers
                .collect(Collectors.toMap(customer -> customer.getEmail(),
                        customer -> customer.getOrders()
                                .stream()
                                .map(order -> order.getPaymentInfo())
                                .distinct()
                                .count()
                ));
    }
    static Map<String, Long> cardsCountForCustomer_Armine(final Stream<Customer> customers) {
        return customers.collect(Collectors.toMap(Customer::getEmail,
                customer -> customer.getOrders().stream()
                        .map(order -> order.getPaymentInfo().getCardNumber())
                        .distinct()
                        .count()));
    }

    static Map<String, Long> cardsCountForCustomer_Arsen(final Stream<Customer> customers) {
        return customers.collect(Collectors.toMap(Customer::getEmail, customer -> customer.getOrders().stream()
                .filter(Objects::nonNull)
                .map(Order::getPaymentInfo)
                .filter(Objects::nonNull)
                .map(PaymentInfo::getCardNumber)
                .distinct()
                .count()));
    }


    static Map<String, Long> cardsCountForCustomerNare(final Stream<Customer> customers) {
        Map<String, Long> cardsCount =customers
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(o -> o.getEmail(),o -> o.getOrders().stream().map(order -> order.getPaymentInfo().getCardNumber())))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, stringStreamEntry -> stringStreamEntry.getValue().distinct().count()));


        return cardsCount;

    }



    /**
     * Task 5 (⚫⚫⚫⚫⚫)
     *
     * Given a stream of customers, return the optional, containing the most popular country name,
     * that is, the name of the country set in addressInfo by the biggest amount of customers.
     * If there are two or more countries with the same amount of customers, return the country name that has a smallest length.
     * If customer stream is empty, Optional.empty should be returned.
     *
     * Example: For the stream, containing
     *      Customer#1 -> USA
     *      Customer#2 -> France
     *      Customer#3 -> Japan
     *      Customer#4 -> USA
     *      Customer#5 -> Japan
     *
     *      "USA" should be returned.
     *
     * @param customers stream of customers
     * @return java.util.Optional containing the name of the most popular country
     */

    static Optional<String> mostPopularCountry_Narek(final Stream<Customer> customers) {

        List<Optional<String>> listCountries = customers
                .map(customer -> Optional.of(customer.getAddress().getCountry()))
                .collect(Collectors.toList());

        if (listCountries.isEmpty()) {
            return Optional.empty();
        }

        Map<Optional<String>, Integer> stringIntegerMap = new HashMap<>();

        for (Optional<String> country : listCountries) {
            if (stringIntegerMap.containsKey(country)) {
                stringIntegerMap.put(country, stringIntegerMap.get(country) + 1);
            } else {
                stringIntegerMap.put(country, 1);
            }
        }

        Integer maxPopularity = Collections.max(stringIntegerMap.values());

        List<Optional<String>> listOfMostPopularCountries = new ArrayList<>();

        for (Optional<String> country : stringIntegerMap.keySet()) {
            if (stringIntegerMap.get(country) == maxPopularity) {
                listOfMostPopularCountries.add(country);
            }
        }

        if (listOfMostPopularCountries.contains(Optional.empty())) {
            return Optional.empty();
        }

        Optional<String> mostPopularCountry = Optional.empty();
        Integer length = Integer.MAX_VALUE;

        for (Optional<String> country : listOfMostPopularCountries) {
            if (!country.equals(Optional.empty()) && country.toString().length() < length) {
                mostPopularCountry = country;
                length = country.toString().length();
            }
        }

        return mostPopularCountry;
    }

    static Optional<String> mostPopularCountry_Armine(final Stream<Customer> customers) {
        List<Customer> customerList = customers.collect(Collectors.toList());
        if (customerList.size() == 0) {
            return Optional.empty();
        }
        Map<String, Long> customersCountryMap = customerList.stream()
                .filter(Objects::nonNull)
                .map(Customer::getAddress)
                .filter(Objects::nonNull)
                .map(AddressInfo::getCountry)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Long maxCountOfCustomers = customersCountryMap.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getValue();
        return customersCountryMap.entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue().equals(maxCountOfCustomers))
                .min(Comparator.comparing(stringLongEntry -> stringLongEntry.getKey().length()))
                .map(Map.Entry::getKey);

    }

    static Optional<String> mostPopularCountryNare(final Stream<Customer> customers) {

        Optional<Map.Entry<String, Long>> stringOptional= customers.
                filter(Objects::nonNull).
                collect(Collectors.groupingBy(customer -> customer.getAddress().getCountry(), Collectors.counting())).
                entrySet().
                stream().
                max((o1, o2) -> {
                    if(o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().length() - o2.getKey().length();
                    }
                    return Math.toIntExact(o1.getValue() - o2.getValue());
                });
        if(stringOptional.isPresent()) {
            return Optional.of(stringOptional.get().getKey());
        }

        return Optional.empty();
    }





    /**
     * Task 6 (⚫⚫⚫⚫⚫)
     *
     * Given a stream of customers, return the average product price for the provided credit card number.
     *
     * Info: If order contains the following order items:
     *  [
     *      Product1(price = 100$, quantity = 2),
     *      Product2(price = 160$, quantity = 1)
     *  ]
     * then the average product price for this order will be 120$ ((100 * 2 + 160 * 1) / 3)
     *
     * Hint: Since product prices are represented as BigDecimal objects, you are provided with the collector implementation
     *       to compute the average value of BigDecimal stream.
     *
     * @param customers stream of customers
     * @param cardNumber card number to check
     * @return average price of the product, ordered with the provided card
     */
    static BigDecimal averageProductPriceForCreditCard_Armine(final Stream<Customer> customers, final String cardNumber) {
        List<OrderItem> orderList = customers
                .filter(Objects::nonNull)
                .map(Customer::getOrders)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(order -> order.getPaymentInfo().getCardNumber().equals(cardNumber))
                .map(Order::getOrderItems)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        int productsQuantity = orderList.stream()
                .map(OrderItem::getQuantity)
                .mapToInt(Integer::intValue).sum();

        if (productsQuantity == 0) {
            return BigDecimal.ZERO;
        }

        return orderList.stream()
                .map(orderItem -> orderItem.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(productsQuantity), 3, RoundingMode.HALF_DOWN);


    }

    static BigDecimal averageProductPriceForCreditCard_Narek(final Stream<Customer> customers, final String cardNumber) {
        List<OrderItem> orderItemListByCardNumber = customers
                .filter(Objects::nonNull)
                .map(customer -> customer.getOrders())
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(order -> order.getPaymentInfo().getCardNumber().equals(cardNumber))
                .map(order -> order.getOrderItems())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (orderItemListByCardNumber.size() == 0) {
            return BigDecimal.ZERO;
        }

        Integer productsQuantityByCardNumber = orderItemListByCardNumber.stream()
                .map(orderItem -> orderItem.getQuantity())
                .reduce(0, Integer::sum);

        BigDecimal averagePrice = orderItemListByCardNumber.stream()
                .map(orderItem -> orderItem.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(productsQuantityByCardNumber), 3);

        return averagePrice;
    }


    static BigDecimal averageProductPriceForCreditCard_NareFirstSolution(final Stream<Customer> customers, final String cardNumber) {


        Double average =customers.
                filter(Objects::nonNull).
                map(customer -> customer.
                        getOrders()).
                flatMap(Collection::stream).
                filter(order -> order.getPaymentInfo().getCardNumber().equals(cardNumber)).
                map(order -> order.getOrderItems()).
                flatMap(Collection::stream)
                .collect(Collectors.collectingAndThen(Collectors.toSet(), orderItems -> {
                    Double sum =orderItems
                            .parallelStream()
                            .mapToDouble(value -> value.getProduct().getPrice().multiply(BigDecimal.valueOf(value.getQuantity())).doubleValue()).sum();
                    Double qty = orderItems.parallelStream().mapToDouble(value -> value.getQuantity().doubleValue()).sum();
                    Double division = sum/qty;
                    return division;
                }));


        return BigDecimal.valueOf(average);


    }


    static BigDecimal averageProductPriceForCreditCard_NareSecondSolution(final Stream<Customer> customers, final String cardNumber) {
        final ResultContainer resultContainer = new ResultContainer();
        customers.
                filter(Objects::nonNull).
                map(customer -> customer.
                        getOrders()).

                flatMap(Collection::stream).
                filter(order -> order.getPaymentInfo().getCardNumber().equals(cardNumber)).
                map(order -> order.getOrderItems()).
                flatMap(Collection::stream)
                .forEach(orderItem -> resultContainer.add(orderItem.getProduct().getPrice(), orderItem.getQuantity()));
        return resultContainer.average();
    }



}
class ResultContainer{
    private BigDecimal sum = BigDecimal.ZERO;
    private Integer qty = 0;

    public  void add(BigDecimal _sum, Integer _qty){
        sum = sum.add(_sum);
        qty = qty + _qty;
    }

    public BigDecimal average(){
        return sum.divide(BigDecimal.valueOf(qty.doubleValue()), RoundingMode.HALF_EVEN).setScale(2, RoundingMode.HALF_EVEN);
    }
}