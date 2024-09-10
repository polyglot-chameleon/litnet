package model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.List;

@Node("Author")
public class AuthorEntity {
    @Id
    @GeneratedValue
    private String id;

    private String fullName;

    @Relationship(type = "POEMS")
    private List<PoemEntity> poems;
}
