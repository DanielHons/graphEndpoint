package graphEndpoint.dataConnection.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;


/**
 * Created by Daniel on 15.04.2017.
 */

abstract public class DomainEntity{
    @GraphId private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DomainEntity(){}
}
