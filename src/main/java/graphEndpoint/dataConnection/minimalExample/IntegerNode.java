package graphEndpoint.dataConnection.minimalExample;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * Created by Daniel Hons on 28.04.2017.
 */
@NodeEntity
public class IntegerNode {
    @GraphId private Long id;

    @Property
    private long value;

    @Property
    public IntegerNode previousNode;

    @Property
    public  IntegerNode nextNode;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }
}
