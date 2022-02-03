import org.w3c.dom.NodeList;

public abstract class ListItem {
    /*
    Create an abstract class to define items that can be stored in a tree.

Implement the following:
*/
//1.  ListItem (abstract class)
//
//    -  It has three protected fields. Two ListItems called rightLink and leftLink, and an Object called value.
    ListItem rightLink;
    ListItem leftLink ;
    Object value;
//    -  A constructor that takes an Object and initialises the field value with the parameter that was passed in.

    public ListItem(Object value) {
        this.value = value;
    }

//    -  And seven methods:
//
//        -  next(), setNext(), previous(), setPrevious() and compareTo() which are package-private and abstract (see child class for declaration).
    abstract ListItem next();
    abstract ListItem setNext(ListItem listItem);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem listItem);
    abstract int compareTo(ListItem listItem);
//        -  getValue(), takes no parameters and returns its value.

    public Object getValue() {
        return value;
    }

//        -  setValue(), takes an Object and assigns it to value.

    public void setValue(Object value) {
        this.value = value;
    }

//       
/*



TIP:  The rules for adding an item to the linked tree are: 

          If the head of the tree is null, make the head refer to the item to be added.

          If the item to be added is less than the current item in the tree, add the item before the current item (i.e., make the previous item's "next" refer to the new item, and the new item's "next" refer to the current item).

          If the item to be added is greater than the current item, move onto the next item and compare again (if there is no next item, then that is where the new item belongs).

TIP:  When adding items to a Binary Search Tree, if the item to be added is less than the current item - then move to the left.

         If it is greater than the current item - then move to the right.

         The new item is added when an attempt to move in the required direction would involve following a null reference.

         Once again, duplicates are not allowed.

TIP:  Inorder = print the previous node, then the parent node, and then the next node (left -> node -> right).

TIP:  Be extremely careful with the spelling of the names of the fields, constructors and methods.

TIP:  Be extremely careful about spaces and spelling in the printed output from the traverse() method.

NOTE:  All fields are private (unless stated otherwise).

NOTE:  All constructors are public.

NOTE:  All methods are public (unless stated otherwise).

NOTE:  Do not add a main method to the solution code.
     */
}
