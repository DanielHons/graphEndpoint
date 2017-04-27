package graphEndpoint.dataConnection.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * Created by Daniel on 15.04.2017.
 */
@NodeEntity(label = "Person")
public class Person extends DomainEntity {

    @Property(name="firstName") private String firstName;
    @Property(name="lastName") private String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
