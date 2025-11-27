package db.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node("Author")
public class AuthorEntity {

    @Id
    @GeneratedValue
    private String elementId;

    private final String fullName;

    @JsonCreator
    public AuthorEntity(@JsonProperty("fullName") String fullName) {
        this.fullName = fullName;
    }
}
