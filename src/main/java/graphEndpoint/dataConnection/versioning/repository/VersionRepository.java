package graphEndpoint.dataConnection.versioning.repository;

import graphEndpoint.dataConnection.domain.DomainEntity;
import graphEndpoint.dataConnection.versioning.domain.VersionWrapper;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
public interface  VersionRepository<T extends DomainEntity> extends GraphRepository<VersionWrapper<T>>{

}
