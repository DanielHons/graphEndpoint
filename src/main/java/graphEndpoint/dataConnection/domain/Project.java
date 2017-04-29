package graphEndpoint.dataConnection.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * Created by Daniel Hons on 19.04.2017.
 * Class hold project entity and relates to a customer, an invoice address and and a contact person
 */
@NodeEntity(label="Project")
public class Project extends DomainEntity {
    @Property(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Property(name = "invoiceAddress")
    private Address invoiceAddress;

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }


    @Property(name="contact") private Person contact;

    public Person getContact() {
        return contact;
    }

    public void setContact(Person contact) {
        this.contact = contact;
    }
}