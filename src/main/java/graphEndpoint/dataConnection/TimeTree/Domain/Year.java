package graphEndpoint.dataConnection.TimeTree.Domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by Daniel Hons on 21.04.2017.
 */
@NodeEntity
public class Year extends TimeNode {

    public Year() {
    }


    public Year(TimeNode parent, int value) {
        this.value = value;
        this.parent = parent;

        this.setFirstChild(null);
        this.setLastChild(null);

        //If i am the first child
        if (this.parent.children.isEmpty()) {
           this.parent.setFirstChild(this);
           this.parent.setLastChild(this);
        }
        //I am lower than the old first child
        else if (this.parent.getFirstChild().value > this.value){
            this.makeThisParentsFirstChild();
        }


        //I am higher than the old last child
        else if (this.parent.getLastChild().value < this.value)
            this.makeThisParentsLastChild();

        else this.orderThisInParentsChildren();

    }

    private void makeThisParentsFirstChild() {
        TimeNode oldFirst=parent.getFirstChild();
        oldFirst.setPreviousNode(this);
        this.setNextNode(oldFirst);
        parent.setFirstChild(this);
    }

    private void makeThisParentsLastChild() {
        TimeNode oldLast=parent.getLastChild();
        this.setPreviousNode(oldLast);
        oldLast.setNextNode(this);
        parent.setLastChild(this);
    }

    private void orderThisInParentsChildren(){
        TimeNode biggestLower=null;
        TimeNode lowestBigger=null;
        for (TimeNode child:parent.children) {
            if (child.value<this.value) biggestLower=higherNode(biggestLower,child);
            else lowestBigger=lowerNode(lowestBigger,child);
        }
        biggestLower.setNextNode(this);
        this.setNextNode(lowestBigger);
    }

    private TimeNode lowerNode(TimeNode a, TimeNode b)
    {
        if (a==null||a.value>b.value) return b;
        return a;
    }

    private TimeNode higherNode(TimeNode a, TimeNode b)
    {
        if (a==null||a.value<b.value) return b;
        return a;
    }
}
