package com.kodilla.multi.parallel.world;

import com.kodilla.multi.parallel.BookProcessTask;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinCountries {
    public static void main(String[] args) {
        List<Country> countries = Countries.createCountriesList();
        ForkJoinPool thePool = new ForkJoinPool();
        Long result = thePool.invoke(new CountryProcessTask(countries));
        System.out.println(result);
    }
}
