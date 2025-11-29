package controllers;

import db.model.AuthorEntity;
import db.model.ConceptEntity;
import db.model.PoemEntity;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping(path = "/next", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<PoemEntity> getNext(@RequestBody PoemEntity lastPoem) {
        return poemRepository
            .findSimilar(lastPoem.getElementId())
            .switchIfEmpty(poemRepository.random());
    }

    @PostMapping(path = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<PoemEntity> getPoemsByAuthor(@RequestBody AuthorEntity author) {
        return poemRepository.getPoemsByAuthor(author.getElementId());
    }

    @PostMapping(path = "/concept", produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<PoemEntity> getPoemsByConcept(@RequestBody ConceptEntity concept) {
        return poemRepository.getPoemsByConcept(concept.getElementId());
    }

    @PostMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    Publisher<PoemEntity> search(@RequestBody PoemEntity examplePoem) {
        ExampleMatcher matcher = ExampleMatcher.matching()
            .withIgnoreCase()
            .withMatcher("title", m -> m.contains())
            .withMatcher("content", m -> m.contains());

        Example<PoemEntity> example = Example.of(examplePoem, matcher);

        return poemRepository.findBy(example, q -> q.all());
    }
}
