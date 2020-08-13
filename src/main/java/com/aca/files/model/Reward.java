package com.aca.files.model;

import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.*;

public class Reward {

    private final Map<Double, Pair<Integer, Integer>> rangesMap = new HashMap<>();

    public Reward() {
        rangesMap.put(1.0, Pair.of(1500, 3000));
        rangesMap.put(1.2, Pair.of(3001, 6000));
        rangesMap.put(1.5, Pair.of(6001, 10000));
        rangesMap.put(1.7, Pair.of(10001, 13000));
        rangesMap.put(1.8, Pair.of(13001, 15000));
    }

    public Double profitCalculator(BigDecimal price) {
         return rangesMap
                .entrySet()
                .stream()
                .mapToDouble(value -> {
                    Double profit= 0.0;
                    if (price.compareTo(BigDecimal.valueOf(value.getValue().getLeft())) >= 0
                            && price.compareTo(BigDecimal.valueOf(value.getValue().getRight())) <= 0) {
                        profit = price.multiply(BigDecimal.valueOf(value.getKey() / 100)).doubleValue();

                    }
                    return profit;
                }).sum();


    }


}
