package graphEndpoint.dataConnection.versioning;

import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
public interface CurrentVersionRepository<T extends VersionedNode> extends GraphRepository<CurrentVersion<T>> {
}
