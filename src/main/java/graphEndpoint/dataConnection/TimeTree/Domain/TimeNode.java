package graphEndpoint.dataConnection.TimeTree;

import org.neo4j.graphdb.Node;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.neo4j.annotation.Query;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Daniel Hons on 19.04.2017.
 */
@NodeEntity(label="TimeNode")
public abstract class TimeNode {
    @GraphId long id;

    @Property(name = "value")
    int value;




}
