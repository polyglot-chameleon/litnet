package controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import db.model.PoemEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repos.PoemRepository;

@RestController
@RequestMapping("/poems")
public class PoemController {
    private final PoemRepository poemRepository;

    public PoemController(PoemRepository poemRepository) {
        this.poemRepository = poemRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<PoemEntity> getAllPoems() {
        return poemRepository.findAll();
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
