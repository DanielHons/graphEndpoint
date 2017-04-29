package graphEndpoint.dataConnection.versioning.repository;

import graphEndpoint.dataConnection.domain.DomainEntity;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
public interface VersionedNodeRepository<T> extends GraphRepository<T> {
}
