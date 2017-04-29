package graphEndpoint.dataConnection.versioning;

import graphEndpoint.dataConnection.domain.DomainEntity;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
@NodeEntity(label="VersionedInteger")
public class VersionedInteger extends DomainEntity{
    @Property  private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
