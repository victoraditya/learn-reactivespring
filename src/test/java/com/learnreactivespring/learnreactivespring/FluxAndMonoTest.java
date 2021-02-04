package com.learnreactivespring.learnreactivespring;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {

    @Test
    public void fluxTest(){

        Flux<String> stringFlux = Flux.just("Spring","Spring Boot","Reactive Spring").log();

     //   stringFlux.subscribe(System.out::println,(e)->System.err.println("Exception is "+e),()-> System.out.println("Finished"));

        StepVerifier.create(stringFlux)
                .expectNext("Spring")
                .expectNext("Spring Boot")
                .expectNext("Reactive Spring")
                .verifyComplete();

    }

    @Test
    public void fluxElementCountTest(){

        Flux<String> stringFlux = Flux.just("Spring","Spring Boot","Reactive Spring").log();

        //   stringFlux.subscribe(System.out::println,(e)->System.err.println("Exception is "+e),()-> System.out.println("Finished"));

        StepVerifier.create(stringFlux)
                .expectNextCount(3)
                .verifyComplete();

    }

}
