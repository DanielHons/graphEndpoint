package graphEndpoint.dataConnection.repository;

import graphEndpoint.dataConnection.domain.Customer;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Daniel on 15.04.2017.
 */

@Component
public interface CustomerRepository extends GraphRepository<Customer> {
}
