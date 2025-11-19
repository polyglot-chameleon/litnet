package controllers;

import db.model.PoemEntity;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
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

    @PostMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    Publisher<PoemEntity> search(@RequestBody PoemEntity examplePoem) {
        ExampleMatcher matcher = ExampleMatcher.matching()
            .withIgnoreCase()
            .withMatcher("content", m -> m.contains())
            .withMatcher("feature", m -> m.contains());

        Example<PoemEntity> example = Example.of(examplePoem, matcher);

        return poemRepository.findBy(example, q -> q.all());
    }
}
