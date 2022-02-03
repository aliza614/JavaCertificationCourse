import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyLinkedList implements NodeList{
    //3.  MyLinkedList (concrete class)
    //
    //    -  It implements NodeList .
    //
    //    -  It has one field of type ListItem called root.
    private ListItem root=null;
    //    -  A constructor that takes a ListItem and initialises the field root with the newly passed in parameter.

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    //    -  And four methods:
    //
    //        -  getRoot(), getter for root.

    public ListItem getRoot() {
        return root;
    }

    //        -  addItem(), takes a ListItem and returns true if it was added successfully or false otherwise. If the item is already present, it doesn't get added. Use compareTo() to place the item in its proper order.
    //
    public boolean addItem(ListItem listItem){
        //????
        if (this.root==null){
            this.root=listItem;
            return true;
        }else {
            ListItem currentItem=this.root;
            while (currentItem!=null){
                int compare=currentItem.compareTo(listItem);
                if (compare<0){
                    //go right in the list
                    if(currentItem.next()!=null){
                        currentItem=currentItem.next();
                    }else{
                        currentItem.setNext(listItem).setPrevious(currentItem);
                        return true;
                    }
                }else if (compare>0){
                    if (currentItem.previous()!=null){
                        currentItem.previous().setNext(listItem).setPrevious(currentItem.previous());
                        listItem.setNext(currentItem).setPrevious(listItem);
                        return true;
                    } else{
                        listItem.setNext(this.root).setPrevious(listItem);
                        this.root=listItem;
                        return true;
                    }
                } else{
                    System.out.println(listItem.getValue()+" is already present, not added.");
                    return  false;
                }

            }
        }
        return false;
    }
    //        -  removeItem(), takes a ListItem and returns true if it was removed successfully or false otherwise.
    public boolean removeItem(ListItem listItem){
        if (this.root==null||listItem==null) return false;
        System.out.println("Deleting item"+listItem.getValue());
        ListItem currentItem=this.root;
        while(currentItem!=null){
            int compare=currentItem.compareTo(listItem);
            if (compare==0)
            {
                //item has been found remove it
                if (currentItem==root)
                    this.root=currentItem.next();
                else {
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next()!=null)
                    {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }else if (compare<0){
                currentItem=currentItem.next();
            }else{//you got past where it would have existed in the list and current item>listItem
                return false;
            }
        }
        return false;
    }
    //        -  traverse(), takes the root as an argument and does not return anything. If the root is null it prints out: The list is empty, otherwise print each value on a separate line.
    public void traverse (ListItem root){
        if (root==null)
        {
            System.out.println("The list is empty");
        }else{
            while (root!=null){
                System.out.println(root.getValue());
                root=root.next();
            }
        }
    }

    @Override
    public Node item(int index) {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }
}
