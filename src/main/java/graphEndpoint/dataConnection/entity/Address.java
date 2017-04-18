package graphEndpoint.dataConnection.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * Created by Daniel on 14.04.2017.
 */
@NodeEntity(label = "Address")
public class Address extends DomainEntity{


    @Property(name="name")
    private String fullName;


}