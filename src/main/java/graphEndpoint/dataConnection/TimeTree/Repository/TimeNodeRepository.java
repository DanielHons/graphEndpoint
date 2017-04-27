package graphEndpoint.dataConnection.TimeTree.Repository;

import graphEndpoint.dataConnection.TimeTree.Domain.Year;
import graphEndpoint.dataConnection.TimeTree.Domain.TimeNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel Hons on 19.04.2017.
 */
@Repository
public interface YearRepository extends GraphRepository<Year> {

    @Query("Match (n:TimeTreeRoot) return n")
    public TimeNode getRoot();

    public Year findByValue(int value);
}
