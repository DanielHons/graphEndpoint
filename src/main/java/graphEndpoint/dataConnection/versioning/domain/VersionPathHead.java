package graphEndpoint.dataConnection.versioning.domain;

import graphEndpoint.dataConnection.domain.DomainEntity;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.UUID;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
@NodeEntity(label="Current")
public class VersionPathHead<T extends DomainEntity> extends VersionWrapper<T> {

    public VersionPathHead(){
        super();
        this.setHistoryUuid(UUID.randomUUID().toString());
    }

    public VersionWrapper<T> createPrevious()
    {
        VersionWrapper<T> previous=new VersionWrapper<>();
        previous.setHistoryUuid(this.getHistoryUuid());
        previous.setPreviousVersionWrapper(this.getPreviousVersionWrapper());
        previous.setNode(this.getNode());
        this.setPreviousVersionWrapper(previous);
        return previous;
    }
}
