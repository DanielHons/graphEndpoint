package graphEndpoint.dataConnection.entity;

import org.neo4j.ogm.annotation.GraphId;


/**
 * Created by Daniel on 15.04.2017.
 */

abstract public class DomainEntity {
    @GraphId private Long id;

    public Long getId() {
        return id;
    }

    public DomainEntity(){}
}
