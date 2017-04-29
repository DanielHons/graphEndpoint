package graphEndpoint.dataConnection.versioning;

import graphEndpoint.dataConnection.versioning.domain.CurrentVersionWrapper;
import graphEndpoint.dataConnection.versioning.domain.VersionWrapper;
import graphEndpoint.dataConnection.versioning.service.VersioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Daniel Hons on 29.04.2017.
 */
@RestController
@RequestMapping("/versioning")
public class VersioningController {
    private String lastInsertedUuid;

    @Autowired
    VersioningService<VersionedInteger> versionedIntegerService;

    @RequestMapping("/add")
    public VersionWrapper<VersionedInteger> addNew()
    {
        VersionedInteger newNode=new VersionedInteger();
        newNode.setValue(5);
        CurrentVersionWrapper<VersionedInteger> current=versionedIntegerService.create(newNode);
        lastInsertedUuid=current.getHistoryUuid();
        return current;
    }

    @RequestMapping("/update")
    public VersionWrapper<VersionedInteger> update()
    {
        CurrentVersionWrapper<VersionedInteger> currentVersion=versionedIntegerService.getCurrentVersion(lastInsertedUuid);
        int newValue=currentVersion.getNode().getValue()+1;
        VersionedInteger newNode=new VersionedInteger();
        newNode.setValue(newValue);
        return versionedIntegerService.pushNewVersion(currentVersion,newNode);
    }

    @RequestMapping("/rm")
    public VersionWrapper<VersionedInteger> removeBinding(){


        return versionedIntegerService.removeBind(this.lastInsertedUuid);

    }
}
