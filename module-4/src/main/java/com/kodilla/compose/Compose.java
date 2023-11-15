package com.kodilla.compose;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Compose {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Service1 service1 = new Service1();
        Service2 service2 = new Service2();
        CompletableFuture<List<String>> composedResult = service1
                .getData()
                .thenCombine(service2.getData(),(result1, result2)
                        -> Stream.concat(result1.stream(),result2.stream())
                        .distinct().collect(Collectors.toList()));
        System.out.println(composedResult.get());
    }
}
