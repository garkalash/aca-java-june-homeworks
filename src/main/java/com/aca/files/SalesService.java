package com.aca.files;

import com.aca.files.model.SoldItem;
import com.aca.files.utility.JsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author: garik
 * @created: 8/8/2020, 9:11 AM
 */
public class SalesService {

    public static void main(String[] args) {
            SalesService salesService = new SalesService();
            salesService.read();
    }

    public void read(){
        try (Reader reader = new FileReader(new File("D:\\project\\lvl_course_homeworks\\src\\main\\resources\\car_sales.json"))) {
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


}
