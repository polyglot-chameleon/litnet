package repos;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

import db.model.PoemEntity;

public interface PoemRepository extends ReactiveNeo4jRepository<PoemEntity, String> {
}
