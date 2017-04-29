package graphEndpoint.dataConnection.minimalExample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Daniel Hons on 28.04.2017.
 */
@RestController
public class DummyController {

    @Autowired SortingService sortingService;

    @RequestMapping("/testsort")
    public String add6Random()
    {
        for (int i=0; i<=6; i++)
        {
            sortingService.insertNodeWithValue(Math.round(Math.random()*30000));
        }
        return "done";
    }
}
