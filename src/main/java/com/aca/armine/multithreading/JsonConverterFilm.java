package com.aca.armine.multithreading;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.List;
import java.util.Objects;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class JsonConverterFilm {
    public ConcurrentMap<String, Integer> readFromJson() {
        File file = new File(
                Objects.requireNonNull(Seller.class.getClassLoader().getResource("films.json")).getFile());
        Gson gson = JsonBuilderFilm.GSON_INSTANCE();
        List<Film> films = null;
        try (Reader reader = new FileReader(file)) {
            films = gson.fromJson(reader, new TypeToken<List<Film>>() {
            }.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        ConcurrentMap<String, Integer> filmsMap = new ConcurrentHashMap<>();
        List<String> genre = films.stream().map(Film::getGenre).collect(Collectors.toList());
        for (String s : genre) {
            Integer genreCount = films.stream()
                    .filter(film -> film.getGenre().equals(s))
                    .map(Film::getTicketCount).mapToInt(Integer::intValue).sum();
            filmsMap.put(s, genreCount / 2);
        }
        return filmsMap;
    }

    public void writeInJson1(CopyOnWriteArrayList<String> transactions) {
        File file = new File("src/main/resources/" + "transactions.json");
        Gson gson = new Gson();
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(transactions.toString(), writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

