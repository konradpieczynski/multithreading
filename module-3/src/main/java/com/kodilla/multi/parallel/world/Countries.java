package com.kodilla.multi.parallel.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Countries {
    public static List<Country> createCountriesList(){
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            countries.add(new Country(random.nextLong(100000000)));
        }
        return countries;
    }
}
