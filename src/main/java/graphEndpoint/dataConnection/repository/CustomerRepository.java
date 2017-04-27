package graphEndpoint;

import graphEndpoint.dataConnection.entity.Customer;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel on 15.04.2017.
 */

@Component
public interface CustomerRepository extends GraphRepository<Customer> {
}
