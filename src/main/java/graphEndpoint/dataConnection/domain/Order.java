package graphEndpoint.dataConnection.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * Created by Daniel Hons on 19.04.2017.
 */
@NodeEntity(label = "Order")
public class Order extends DomainEntity {

    enum TIME_UNIT
    {
        DAYS,HOURS;
    }

    @Property(name = "project") private Project project;
    @Property(name="untit") private TIME_UNIT timeUnit;
    @Property(name="amount") private int amount;

    public void setFrom()
    {
        
    }

    /*
    TODO timetree days validFrom, validUntil
     */


}
