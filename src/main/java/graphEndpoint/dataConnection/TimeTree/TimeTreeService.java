package graphEndpoint.dataConnection.TimeTree;

import graphEndpoint.dataConnection.TimeTree.Domain.TimeNode;
import graphEndpoint.dataConnection.TimeTree.Domain.Year;
import graphEndpoint.dataConnection.TimeTree.Repository.TimeNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

/**
 * Created by Daniel Hons on 19.04.2017.
 */
@Service
public class TimeTreeService {

    @Autowired
    TimeNodeRepository timeNodeRepository;

    public TimeNode getExistingYearNode(int year) {
        TimeNode foundYear = timeNodeRepository.findYearByValue(year);
        if (foundYear==null) {
            Long rootID=timeNodeRepository.getRoot().getId();
            TimeNode root=timeNodeRepository.findOne(rootID,2); //TODO get Root in one step
            foundYear=root.createChild(year);
            timeNodeRepository.save(foundYear,2);

        }
         return foundYear;
    }


}
