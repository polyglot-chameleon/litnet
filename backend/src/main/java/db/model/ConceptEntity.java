package db.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;

@Data
@Node("Concept")
public class ConceptEntity {
    @Id
    @GeneratedValue
    private String id;

    private final String name;
}
