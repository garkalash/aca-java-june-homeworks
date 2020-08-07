package strem.worldcountry;



public class Main {
    public static void main(String[] args) {

        Country armenia = new Country("ARM", "Armenia", 3000000, 101);
        City yerevan = new City(101, "Yerevan", "ARM", 1060138);
        City gyumri = new City(102, "Gyumri", "ARM", 118600);
        City vanadzor = new City(103, "Vanadzor", "ARM", 78000);
        armenia.putCities(yerevan,gyumri,vanadzor);

        Country usa = new Country("USA", "United States of America", 331139904, 201);
        City washington = new City(201, "Washington", "USA", 705750);
        City newYork = new City(202, "New York", "USA", 8175133);
        City atlanticCity = new City(203, "Atlantic City", "USA", 39558);
        usa.putCities(washington,newYork,atlanticCity);

        Country france = new Country("FR", "France", 65283584, 301);
        City paris = new City(301, "Paris", "FR", 2150000);
        City lyon = new City(302, "Lyon", "FR", 516092);
        City nantes = new City(303, "Nantes", "FR", 309345);
        france.putCities(paris,lyon,nantes);

        System.out.println(armenia.getHighestPopulatedCity().toString());
        System.out.println(france.getHighestPopulatedCity().toString());
        System.out.println(usa.getHighestPopulatedCity().toString());



    }


}
