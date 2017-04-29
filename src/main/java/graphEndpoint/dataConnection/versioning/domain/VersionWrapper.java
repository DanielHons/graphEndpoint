package graphEndpoint.dataConnection.versioning.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphEndpoint.dataConnection.domain.DomainEntity;
import org.neo4j.ogm.annotation.*;

import java.util.Date;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
@NodeEntity
public class VersionWrapper<T>{
    @GraphId
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Relationship(type = "holds")
    private T node;

    @Property(name="updatedAt")
    protected Long updatedAt;

    @Property(name = "historyUuid")
    @Index
    private String historyUuid;

    @JsonIgnore
    @Relationship(type="previous")
    private VersionWrapper<T> previousVersionWrapper =null;

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
    public VersionWrapper<T> getPreviousVersionWrapper() {
        return previousVersionWrapper;
    }

    public void setPreviousVersionWrapper(VersionWrapper<T> previousVersionWrapper) {
        this.previousVersionWrapper = previousVersionWrapper;
    }

    public VersionWrapper() {
        this.updatedAt = (new Date()).getTime();
    }


    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
