package graphEndpoint.dataConnection.repository;

import graphEndpoint.dataConnection.entity.Customer;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel on 15.04.2017.
 */

@Repository
public interface CustomerRepository extends GraphRepository<Customer> {
}
