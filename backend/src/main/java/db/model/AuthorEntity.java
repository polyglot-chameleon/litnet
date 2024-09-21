package db.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Node("Author")
public class AuthorEntity {
    @Id
    @GeneratedValue
    private String id;

    private String fullName;
}
