package graphEndpoint.dataConnection.TimeTree.Repository;


import graphEndpoint.dataConnection.TimeTree.Domain.TimeNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel Hons on 19.04.2017.
 */
@Repository
public interface TimeNodeRepository extends GraphRepository<TimeNode> {

    @Query("Merge (n:TimeTree:TimeTreeRoot{value:0}) return n")
    public TimeNode getRoot();

    @Query("MATCH (r:TimeTree:TimeTreeRoot)-[:CHILD]->(n:TimeTree:Year{value:{0}}) return n")
    public TimeNode findYearByValue(int value);

}
