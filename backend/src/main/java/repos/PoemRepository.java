package repos;

import db.model.PoemEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Mono;

public interface PoemRepository
    extends ReactiveNeo4jRepository<PoemEntity, String> {
    @Query(
        """
        MATCH (a:Author)<-[ar:AUTHOR]-(p:Poem)-[cr:CONCEPTS]->(c:Concept)
        RETURN a, ar, p, COLLECT(cr), COLLECT(c)
        ORDER BY rand()
        LIMIT 1;
        """
    )
    public Mono<PoemEntity> random();

    @Query(
        """
        MATCH (p1:Poem)
        WHERE elementId(p1) = "$poemId"
        MATCH (a:Author)<-[ar:AUTHOR]-(p2:Poem)-[cr:CONCEPTS]->(c:Concept)
        WHERE elementId(p1) <> elementId(p2)
        RETURN a, ar, p2, COLLECT(cr), COLLECT(c), COUNT(c) AS sharedConceptCount
        ORDER BY sharedConceptCount DESC
        LIMIT 1
        """
    )
    public Mono<PoemEntity> findSimilar(@Param("poemId") String poemId);
}
