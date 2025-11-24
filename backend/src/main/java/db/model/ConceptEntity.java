package db.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node("Concept")
public class ConceptEntity {

    @Id
    @GeneratedValue
    private String elementId;

    private final String name;

    @JsonCreator
    public ConceptEntity(@JsonProperty("name") String name) {
        this.name = name;
    }
}
