package controllers;

import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import db.model.PoemEntity;
import reactor.core.publisher.Flux;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;
import repos.PoemRepository;

@RestController
@RequestMapping("/poems")
public class PoemController {
    private final PoemRepository poemRepository;

    public PoemController(PoemRepository poemRepository) {
        this.poemRepository = poemRepository;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<PoemEntity> getPoemById(@PathVariable String id) {
        return poemRepository.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<PoemEntity> getAllPoems() {
        return poemRepository.findAll();
    }

    @PostMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    Publisher<PoemEntity> search(@RequestBody PoemEntity examplePoem) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("content", m -> m.contains().ignoreCase())
                .withMatcher("feature", m -> m.contains().ignoreCase());

        Example example = Example.of(examplePoem, matcher);

        return poemRepository.findBy(example, q -> q.all());
    }

    @PutMapping
    Mono<PoemEntity> createOrUpdate(@RequestBody PoemEntity newPoem) {
        return poemRepository.save(newPoem);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable String id) {
        return poemRepository.deleteById(id);
    }

}
