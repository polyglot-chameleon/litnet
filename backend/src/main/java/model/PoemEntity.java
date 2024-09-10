package model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.List;

@Node("Poem")
public class PoemEntity {
    @Id @GeneratedValue
    private String id;
    private final String title;
    private final String content;


//    @Relationship(type = "CONCEPTS")
//    private List<ConceptEntity> concepts;

    public PoemEntity(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

