package com.aca.armine.multithreading;

import com.google.gson.*;

import java.math.BigDecimal;

public class JsonBuilderFilm {
    public static Gson GSON_INSTANCE() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<Film> deserializer = (json, typeOfT, context) -> {
            JsonObject jsonObject = json.getAsJsonObject();
            String id = jsonObject.get("_id").getAsString();
            String genre = jsonObject.get("genre").getAsString();
            BigDecimal price = new BigDecimal(jsonObject.get("price").getAsString()
                    .replaceAll("[^0-9.]", ""));
            Integer ticketCount = jsonObject.get("ticketCount").getAsInt();
            Integer year = jsonObject.get("year").getAsInt();
            Film film = new Film();
            film.setId(id);
            film.setGenre(genre);
            film.setPrice(price);
            film.setTicketCount(ticketCount);
            film.setYear(year);
            return film;
        };
        gsonBuilder.registerTypeAdapter(Film.class, deserializer);
        return gsonBuilder.create();
    }
    public static Gson GSON_INSTANCE2() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        JsonSerializer<Seller> serializer = (seller, type, jsonSerializationContext) -> {
            Gson gson = new Gson();

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Seller's name",
                    gson.toJson(seller.getSellerName()));
            jsonObject.addProperty("TicketProviderCompany",
                    gson.toJson(seller.getCompany().getName()));
            jsonObject.addProperty("Film's Genre",
                    gson.toJson(seller.getBuyer().getGenre()));
            jsonObject.addProperty("Tickets count",
                    gson.toJson(seller.getBuyer().getCount()));
            return jsonObject;

        };
        gsonBuilder.registerTypeAdapter(Seller.class, serializer);

        return gsonBuilder.create();
    }

}