package com.kodilla.multi.barrier.race;

import com.kodilla.multi.barrier.FinalStep;

import java.util.concurrent.CyclicBarrier;

public class SumApp {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, new FinalStep());

        for (int n = 0; n < 5; n++)
            launchTheThread(barrier, n);
    }

    private static void launchTheThread(CyclicBarrier barrier, int number) {
        new SumRace(barrier, number);
    }
}
