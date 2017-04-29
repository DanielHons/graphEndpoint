package graphEndpoint.dataConnection.versioning.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphEndpoint.dataConnection.domain.DomainEntity;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
@NodeEntity
public class Version<T extends VersionedNode> extends DomainEntity{

    @Relationship(type = "holds")
    private T node;

    @Property(name="updatedAt")
    protected Long updatedAt;

    @Property(name = "historyUuid")
    @Index
    private String historyUuid;

    @JsonIgnore
    @Relationship(type="previous")
    private Version<T> previousVersion=null;

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public String getHistoryUuid() {
        return historyUuid;
    }

    void setHistoryUuid(String historyUuid) {
        this.historyUuid = historyUuid;
    }

    @JsonIgnore
    public Version<T> getPreviousVersion() {
        return previousVersion;
    }

    public void setPreviousVersion(Version<T> previousVersion) {
        this.previousVersion = previousVersion;
    }

    public Version() {
        this.updatedAt = (new Date()).getTime();
    }


    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
