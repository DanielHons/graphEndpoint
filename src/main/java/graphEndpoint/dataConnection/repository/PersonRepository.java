package graphEndpoint.dataConnection.repository;

import graphEndpoint.dataConnection.domain.Person;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Daniel Hons on 28.04.2017.
 */
public interface PersonRepository extends GraphRepository<Person> {
}
