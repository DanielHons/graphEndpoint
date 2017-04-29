package graphEndpoint.dataConnection.versioning.repository;

import graphEndpoint.dataConnection.domain.DomainEntity;
import graphEndpoint.dataConnection.versioning.domain.CurrentVersionWrapper;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
public interface CurrentVersionRepository<T extends DomainEntity> extends GraphRepository<CurrentVersionWrapper<T>> {

    public CurrentVersionWrapper<T> findByHistoryUuid(String uuid, int depth);
}
