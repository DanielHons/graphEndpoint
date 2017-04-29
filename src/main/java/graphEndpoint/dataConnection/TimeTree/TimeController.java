package graphEndpoint.dataConnection.TimeTree;

import graphEndpoint.dataConnection.TimeTree.Domain.TimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Daniel Hons on 21.04.2017.
 */
@Controller
@RequestMapping("/api/timetree")
public class TimeController {

    @Autowired TimeTreeService timeTreeService;


    @RequestMapping("/getYear/{year}")
    @ResponseBody
    public ResponseEntity<TimeNode> getYear(@PathVariable("year") int year)
    {
        TimeNode yearNode=timeTreeService.getExistingYearNode(year);
        return new ResponseEntity<TimeNode>(yearNode, HttpStatus.OK);
    }
}
