package db.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Data
@Node("Poem")
public class PoemEntity {

    @Id
    @GeneratedValue
    private String id;

    private final String title;
    private final List<String> content;

    @Relationship
    private AuthorEntity author;

    @Relationship
    private Set<ConceptEntity> concepts = new HashSet<ConceptEntity>();
}
