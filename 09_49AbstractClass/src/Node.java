import org.w3c.dom.NodeList;

public class Node extends ListItem {
    //2.  Node (concrete class)
    //
    //    -  It extends ListItem.
    //
    //    -  It has a constructor that takes an Object, then calls its parent constructor with the parameter that was passed in.
    //

    public Node(Object value) {
        super(value);
    }

    //    -  And five methods which are package-private:
    //
    //        -  next(), takes no parameters and returns the ListItem to its right.
    ListItem next(){
        return this.rightLink;
    }
    //        -  setNext(), takes a ListItem and sets it as its rightLink, then it returns rightLink.
    //
    ListItem setNext(ListItem listItem){
        return this.rightLink=listItem;
    }
    //        -  previous(), takes no parameters and returns the ListItem to its left.
    //
    ListItem previous(){
        return this.leftLink;
    }

    //        -  setPrevious(), takes a ListItem and sets it as its leftLink, then it returns leftLink.
    //
    ListItem setPrevious(ListItem listItem){
        return this.leftLink=listItem;
    }
    //        -  compareTo(), takes a ListItem and compares it to the ListItem that called this method. Use value from ListItem for comparison. If this value is greater than the value that was passed in, then it should return a number greater than zero. If vice versa, then it should return a number less than zero, and zero if equal.
    @Override
    int compareTo(ListItem listItem){
        if(listItem!=null) {
            return (((String) super.getValue()).compareTo ((String) listItem.value));
        }
        return -1;
    }
}
