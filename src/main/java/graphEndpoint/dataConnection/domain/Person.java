package graphEndpoint.dataConnection.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * Created by Daniel on 15.04.2017.
 */
@NodeEntity(label = "Person")
public class Person extends DomainEntity {

    @Property(name="firstName") private String firstName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Property(name="lastName") private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Property(name="email") private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Property(name="displayName") private String displayName=null;

    public String getDisplayName() {
        if (displayName==null) return firstName+" "+lastName;
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
