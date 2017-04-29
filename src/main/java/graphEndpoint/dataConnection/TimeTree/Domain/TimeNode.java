package graphEndpoint.dataConnection.TimeTree.Domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.*;

/**
 * Created by Daniel Hons on 19.04.2017.
 */
@NodeEntity(label = "TimeTree")
public abstract class TimeNode {

    @GraphId
    Long id;

    public TimeNode() {
    }

    @Property(name = "value")
    int value;

    @JsonIgnore
    @Relationship(type = "CHILD")
    List<TimeNode> children = new ArrayList<TimeNode>();

    @JsonIgnore
    @Relationship(type = "CHILD", direction = Relationship.INCOMING)
    TimeNode parent;

    @JsonIgnore
    @Relationship(type = "FIRST")
    private TimeNode firstChild = null;

    @JsonIgnore
    @Relationship(type = "LAST")
    private TimeNode lastChild = null;

    @JsonIgnore
    @Relationship(type = "NEXT")
    private TimeNode nextNode = null;

    @JsonIgnore
    @Relationship(type = "NEXT", direction = Relationship.INCOMING)
    private TimeNode previousNode = null;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public TimeNode getFirstChild() {
        return firstChild;
    }

    public void addChild(TimeNode child) {
        child.parent = this;
        if (!this.children.contains(child))
            this.children.add(child);
    }

    public void setFirstChild(TimeNode firstChild) {
        this.firstChild = firstChild;
    }

    public TimeNode getLastChild() {

        return lastChild;
    }

    public void setLastChild(TimeNode lastChild) {
        this.lastChild = lastChild;
    }

    public TimeNode getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(TimeNode nextNode) {
        this.nextNode=null;
        if (nextNode==null) return;
        nextNode.previousNode = this;
        this.nextNode = nextNode;
    }

    public TimeNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(TimeNode previousNode) {
        this.previousNode=null;
        if (previousNode==null) return;
        previousNode.nextNode=this;
        this.previousNode = previousNode;
    }

    public TimeNode getParent() {
        return parent;
    }


    public boolean hasChildren() {
        System.out.println("hasChildren: " + this.children.size());
        return !(this.children.size() == 0);
    }

    public List<TimeNode> getChildren() {
        return children;
    }

    public TimeNode createChild(int value) {
        TimeNode newChild = new Year();
        newChild.setValue(value);

        if (!this.hasChildren()) {
            this.setFirstChild(newChild);
            this.setLastChild(newChild);
        } else if (this.getFirstChild().getValue() > value) {
            //new node is first child
            newChild.setNextNode(this.getFirstChild());
            this.setFirstChild(newChild);
        } else if (this.getLastChild().getValue() < value) {
            //new node is last child
            newChild.setPreviousNode(this.getLastChild());
            this.setLastChild(newChild);
        } else {
            TimeNode previous = this.getFirstChild();
            TimeNode next = this.getLastChild();
            for (TimeNode current : this.getChildren()) {
                if (current.getValue() < value){
                    if (current.getValue() > previous.getValue()) previous = current;
                }
                else if (current.getValue() < next.getValue()) next = current;
            }
            System.out.println("Previous is "+previous.getValue());
            System.out.println("Next is "+next.getValue());
            newChild.setPreviousNode(previous);
            newChild.setNextNode(next);
        }
        this.addChild(newChild);
        return newChild;
    }

}
