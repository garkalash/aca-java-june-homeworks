package com.aca.files.utility;

import com.aca.files.model.Car;
import com.aca.files.model.SoldItem;
import com.aca.files.model.User;
import com.google.gson.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: garik
 * @created: 8/8/2020, 10:44 AM
 */
public final class JsonBuilder {

    public static Gson GSON_INSTANCE() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<SoldItem> deserializer = (json, typeOfT, context) -> {
            JsonObject jsonObject = json.getAsJsonObject();
            User seller = new Gson().fromJson(jsonObject.get("seller").toString(), User.class);
            User buyer = new Gson().fromJson(jsonObject.get("buyer").toString(), User.class);
            String id = jsonObject.get("_id").getAsString();
            BigDecimal price = new BigDecimal(jsonObject.get("price").getAsString().replaceAll("[^0-9.]", ""));
            LocalDateTime dateTime = LocalDateTime.parse(jsonObject.get("soldDate").getAsString().replace("Z", ""));
            Car car = new Gson().fromJson(jsonObject.get("car"), Car.class);
            SoldItem soldItem = new SoldItem();
            soldItem.setBuyer(buyer);
            soldItem.setCar(car);
            soldItem.setPrice(price);
            soldItem.setId(id);
            soldItem.setSeller(seller);
            soldItem.setSoldDate(dateTime);
            return soldItem;
        };
        gsonBuilder.registerTypeAdapter(SoldItem.class, deserializer);

        return gsonBuilder.create();
    }

    public static Gson GSON_INSTANCE2() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        JsonSerializer<SoldItem> serializer = (soldItem, type, jsonSerializationContext) -> {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", soldItem.getId());
            DecimalFormat df = new DecimalFormat("###,00");
            jsonObject.addProperty("price", (df.format(soldItem.getPrice()).concat(" USD")));

            jsonObject.addProperty("soldDate", soldItem.getSoldDate().format(DateTimeFormatter.ISO_DATE_TIME));
            jsonObject.add("buyer", new Gson().toJsonTree(soldItem.getBuyer()));
            jsonObject.add("seller", new Gson().toJsonTree(soldItem.getSeller()));
            jsonObject.add("car", new Gson().toJsonTree(soldItem.getCar()));
            return jsonObject;

        };
        gsonBuilder.registerTypeAdapter(SoldItem.class, serializer).create();

        return gsonBuilder.create();
    }


}
