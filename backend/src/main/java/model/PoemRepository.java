package model;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

public interface PoemRepository extends ReactiveNeo4jRepository<PoemEntity, String> { }
