package db.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Data
@Node("Poem")
public class PoemEntity {

    @Id
    @GeneratedValue
    private String elementId;

    private final String title;
    private final List<String> content;

    @Relationship(type = "AUTHOR", direction = Direction.OUTGOING)
    private AuthorEntity author;

    @Relationship(type = "CONCEPTS", direction = Direction.OUTGOING)
    private Set<ConceptEntity> concepts = new HashSet<ConceptEntity>();
}
