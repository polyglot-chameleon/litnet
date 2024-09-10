package controllers;

import model.PoemEntity;
import model.PoemRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/poems")
public class PoemController
{
    private final PoemRepository poemRepository;

    public PoemController(PoemRepository poemRepository){
        this.poemRepository = poemRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<PoemEntity> getAllPoems() {
        return poemRepository.findAll();
    }

    @PutMapping
    Mono<PoemEntity> createOrUpdateMovie(@RequestBody PoemEntity newPoem) {
        return poemRepository.save(newPoem);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable String id) {
        return poemRepository.deleteById(id);
    }

}
