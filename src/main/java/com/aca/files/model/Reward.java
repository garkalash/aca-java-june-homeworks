package com.aca.files.model;

import java.math.BigDecimal;
import java.util.*;

public class Reward {
    BigDecimal price;
    final Map<Double,List<Integer>> rangesMap =new HashMap<>();


    public Reward() {
        rangesMap.put(1.0,Arrays.asList(1500,3000));
        rangesMap.put(1.2,Arrays.asList(3001,6000));
        rangesMap.put(1.5,Arrays.asList(6001,10000));
        rangesMap.put(1.7,Arrays.asList(10001,13000));
        rangesMap.put(1.8,Arrays.asList(13001,15000));



    }
//
    public Double rewardCalculator(BigDecimal price){
        BigDecimal sum = BigDecimal.ZERO;

        for (Map.Entry<Double,List<Integer>> entry:rangesMap.entrySet()){
            if (price.compareTo(BigDecimal.valueOf(entry.getValue().get(0)))>= 0 && price.compareTo(BigDecimal.valueOf(entry.getValue().get(1)))<=0 ) {
                sum = sum.add(price.multiply(BigDecimal.valueOf(entry.getKey() / 100)));
            }
        }
        return sum.doubleValue();
    }

}
