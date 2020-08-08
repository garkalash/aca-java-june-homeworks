package com.aca.files.utility;

import com.aca.files.model.Car;
import com.aca.files.model.SoldItem;
import com.aca.files.model.User;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * @author: garik
 * @created: 8/8/2020, 10:44 AM
 */
public final class JsonBuilder {
    public static Gson GSON_INSTANCE(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<SoldItem> deserializer = (json, typeOfT, context) -> {
            JsonObject jsonObject = json.getAsJsonObject();

            User seller = new Gson().fromJson(jsonObject.get("seller").toString(), User.class);
            User buyer = new Gson().fromJson(jsonObject.get("buyer").toString(), User.class);
            String id = jsonObject.get("_id").getAsString();
            BigDecimal price = new BigDecimal(jsonObject.get("price").getAsString().replace("$", "").replace(",", ""));
            Car car = new Gson().fromJson(jsonObject.get("car"), Car.class);

            SoldItem soldItem = new SoldItem();
            soldItem.setBuyer(buyer);
            soldItem.setCar(car);
            soldItem.setPrice(price);
            soldItem.setId(id);
            soldItem.setSeller(seller);

            return soldItem;
        };
        gsonBuilder.registerTypeAdapter(SoldItem.class, deserializer);

        return gsonBuilder.create();
    }
}
