package model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Concept")
public class ConceptEntity {
    @Id
    @GeneratedValue
    private String id;

    private String name;
}
