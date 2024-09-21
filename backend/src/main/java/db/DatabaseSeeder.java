package db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import db.model.AuthorEntity;
import db.model.ConceptEntity;
import db.model.PoemEntity;
import repos.PoemRepository;

import io.bloco.faker.Faker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Profile("dev")
@Service
public class DatabaseSeeder {

    @Autowired
    private final PoemRepository repo = null;

    private static final Logger log = Logger.getLogger(String.valueOf(DatabaseSeeder.class));

    @EventListener
    @Transactional
    public Mono<Void> down(ContextRefreshedEvent event) {
        log.info("DOWN");
        return repo.deleteAll();
    }

    @EventListener
    @Transactional
    public Flux<PoemEntity> seed(ContextRefreshedEvent event) {
        log.info("UP");
        Faker faker = new Faker();

        List<PoemEntity> poems = new ArrayList<PoemEntity>();

        for (int i = 0; i < 5; i++) {
            PoemEntity poem = new PoemEntity(faker.book.title(), faker.lorem.paragraph());

            poem.setAuthor(new AuthorEntity(faker.artist.name()));
            poem.setConcepts(
                    new HashSet<ConceptEntity>(
                            Arrays.asList(
                                    new ConceptEntity(faker.book.genre()))));

            poems.add(poem);
        }

        return repo.saveAll(poems);
    }

}
