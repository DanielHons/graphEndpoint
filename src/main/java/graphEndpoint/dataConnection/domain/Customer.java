package graphEndpoint.dataConnection.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by Daniel on 14.04.2017.
 */
@NodeEntity(label = "Customer")
public class Customer extends DomainEntity{

    @Property(name="name") private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    @Property(name="createdAt") DomainEntity createdAt;

    public DomainEntity getCreatedAt() {
        return createdAt;
    }


    @Property(name="address") private Address address;
    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}



    @Relationship(type="CONTACT_PERSON", direction = Relationship.INCOMING)
    private List<Person> contactPersons;
    public List<Person> getContactPersons() {
        return contactPersons;
    }


    public void addContact(Person person){contactPersons.add(person);}

}

