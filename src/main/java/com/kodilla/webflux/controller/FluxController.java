package com.kodilla.webflux.controller;

import com.kodilla.webflux.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxController {
    @GetMapping(value = "/strings", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getStrings() {
        return Flux
                .just("a", "b", "c", "d", "e")
                .delayElements(Duration.ofSeconds(2))
                .log();
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Book> getBooks() {
        return Flux
                .just(
                        new Book("Kruk", "Hugo", 1999),
                        new Book("Śłowik", "Witek", 1998),
                        new Book("Mars", "John", 1988))
                .log();
    }
}
