package graphEndpoint.dataConnection.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * Created by Daniel on 14.04.2017.
 */
@NodeEntity
public class Address{

    @GraphId
    private Long id;

    @Property(name="name")
    private String fullName;


}