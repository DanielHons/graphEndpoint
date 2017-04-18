package graphEndpoint.dataConnection.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by Daniel on 14.04.2017.
 */
@NodeEntity(label = "Customer")
public class Customer extends DomainEntity{

    @Property(name="name")
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Relationship(type="CONTACT_PERSON", direction = Relationship.INCOMING)
    private List<Person> contactPersons;

    @Relationship(type="HAS_ADDRESS", direction=Relationship.OUTGOING)
    private List<Address> addresses;

    public List<Person> getContactPersons() {
        return contactPersons;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}

