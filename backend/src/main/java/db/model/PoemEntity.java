package db.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

@Data
@Node("Poem")
public class PoemEntity {
    @Id
    @GeneratedValue
    private String id;

    private final String title;
    private final String content;

    @Relationship
    private AuthorEntity author;

    @Relationship
    private Set<ConceptEntity> concepts = new HashSet<ConceptEntity>();
}
