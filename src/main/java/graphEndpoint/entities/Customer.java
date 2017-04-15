package graphEndpoint.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by Daniel on 14.04.2017.
 */
@NodeEntity
public class Customer{

    @GraphId
    private Long id;

    @Property(name="name")
    private String name;

    @Relationship(type="HAS_ADDRESS", direction=Relationship.OUTGOING)
    private List<Address> addresses;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

