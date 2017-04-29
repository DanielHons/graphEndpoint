package graphEndpoint.dataConnection.versioning.repository;

import graphEndpoint.dataConnection.domain.DomainEntity;
import graphEndpoint.dataConnection.versioning.domain.VersionPathHead;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
public interface VersionPathHeadRepository<T extends DomainEntity> extends GraphRepository<VersionPathHead<T>> {

    public VersionPathHead<T> findByHistoryUuid(String uuid, int depth);

}
