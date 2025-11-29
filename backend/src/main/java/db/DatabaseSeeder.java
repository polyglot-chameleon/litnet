package db;

import db.model.AuthorEntity;
import db.model.ConceptEntity;
import db.model.PoemEntity;
import io.bloco.faker.Faker;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repos.PoemRepository;

@Profile("dev")
@Service
public class DatabaseSeeder {

    @Autowired
    private final PoemRepository repo = null;

    private static final Logger log = Logger.getLogger(
        String.valueOf(DatabaseSeeder.class)
    );

    @EventListener
    public Mono<Void> down(ContextRefreshedEvent event) {
        log.info("DOWN");
        return repo.deleteAll();
    }

    @EventListener
    public Flux<PoemEntity> seed(ContextRefreshedEvent event) {
        log.info("UP");
        Faker faker = new Faker();

        List<PoemEntity> poems = new ArrayList<PoemEntity>();
        List<AuthorEntity> authors = new ArrayList<AuthorEntity>();
        List<ConceptEntity> conceptDomain = new ArrayList<ConceptEntity>();

        for (int i = 0; i < 50; i++) {
            authors.add(new AuthorEntity(faker.artist.name()));
            conceptDomain.add(new ConceptEntity(faker.book.genre()));
        }

        for (int i = 0; i < 1000; i++) {
            PoemEntity poem = new PoemEntity(
                faker.book.title(),
                faker.lorem.paragraphs(10)
            );

            poem.setAuthor(authors.get(i % 50));

            Set<ConceptEntity> concepts = new HashSet<ConceptEntity>();
            for (int j = 0; j < 5; j++) {
                concepts.add(conceptDomain.get((i + j) % 50));
            }
            poem.setConcepts(concepts);
            poems.add(poem);
        }

        return repo.saveAll(poems);
    }
}
