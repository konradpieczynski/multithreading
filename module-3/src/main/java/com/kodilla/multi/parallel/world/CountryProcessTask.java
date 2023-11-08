package com.kodilla.multi.parallel.world;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CountryProcessTask extends RecursiveTask<Long> {
    private final List<Country> countries;

    CountryProcessTask(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    protected Long compute() {
        if (countries.size() <= 10) {
            return countries
                    .stream()
                    .map(CountryProcessTask::processCountry)
                    .reduce(0L, Long::sum);
        } else {
            int middle = countries.size() / 2;
            CountryProcessTask left = new CountryProcessTask(countries.subList(0, middle));
            CountryProcessTask right = new CountryProcessTask(countries.subList(middle, countries.size()));

            left.fork();

            long rightResult = right.compute();
            long leftResult = left.join();


            return leftResult + rightResult;
        }
    }
    private static long processCountry(Country country) {
        return country.getPopulation();
    }    
}
