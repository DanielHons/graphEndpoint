package graphEndpoint.dataConnection.versioning;

import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
public interface  VersionRepository<T extends VersionedNode> extends GraphRepository<Version<T>>{

}
