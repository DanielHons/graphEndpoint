package graphEndpoint.dataConnection.versioning.domain;

import org.neo4j.ogm.annotation.NodeEntity;

import java.util.UUID;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
@NodeEntity(label="Current")
public class CurrentVersion<T extends VersionedNode> extends Version<T> {

    public CurrentVersion(){
        super();
        this.setHistoryUuid(UUID.randomUUID().toString());
    }

    public Version<T> createPrevious()
    {
        Version<T> previous=new Version<>();
        previous.setHistoryUuid(this.getHistoryUuid());
        previous.setPreviousVersion(this.getPreviousVersion());
        previous.setNode(this.getNode());
        this.setPreviousVersion(previous);
        return previous;
    }
}
