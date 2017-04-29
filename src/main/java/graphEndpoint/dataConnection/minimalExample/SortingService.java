package graphEndpoint.dataConnection.minimalExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Daniel Hons on 28.04.2017.
 */
@Service
public class SortingService {

    @Autowired IntegerNodeRepository integerNodeRepository;

    public void insertNodeWithValue(long value)
    {

    }
}
