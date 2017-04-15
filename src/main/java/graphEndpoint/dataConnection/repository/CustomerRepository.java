package graphEndpoint.repository;

import graphEndpoint.dataConnection.entities.Customer;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Daniel on 15.04.2017.
 */
public interface CustomerRepository extends GraphRepository<Customer> {
}
