package graphEndpoint.dataConnection.minimalExample;

import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Daniel Hons on 28.04.2017.
 */
public interface IntegerNodeRepository extends GraphRepository<IntegerNode>{
    public IntegerNode findByValue(int value);
}
