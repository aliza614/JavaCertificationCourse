public class SearchTree implements NodeList{
    //5.  SearchTree (concrete class)
    //
    //    -  It implements NodeList.
    //
    //    -  It has one field of type ListItem called root.
    private ListItem root=null;
    //    -  A constructor that takes a ListItem and initialises the field root with the newly passed in parameter.

    public SearchTree(ListItem root) {
        this.root = root;
    }

    //    -  And five methods:
    //
    //        -  getRoot(), getter for root.

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    //        -  addItem(), same as MyLinkedList.

    @Override
    public boolean addItem(ListItem listItem) {
        if( this.root==null){
            this.root=listItem;
            return true;
        }else{
            ListItem currentItem=this.root;
            while (currentItem!=null) {
                int compare = currentItem.compareTo(listItem);
                if (compare< 0)
                {
                    if (currentItem.next() != null){
                        currentItem=currentItem.next();
                    }
                    else{
                        currentItem.setNext(listItem);
                        return true;
                    }
                }else if (compare>0) {
                    if (currentItem.previous() != null) {//add it before current item
                        currentItem.previous().setNext(listItem).setPrevious(currentItem.previous());
                        listItem.setNext(currentItem);
                        return true;
                    }
                    else{
                        System.out.println(listItem.getValue()+" is already present");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    //        -  removeItem(), same as MyLinkedList.

    @Override
    public boolean removeItem(ListItem listItem) {
        if (listItem==null)
            return false;
        else{
            System.out.println("Deleting item "+listItem.getValue());
            ListItem parentItem=root;
            ListItem currentItem=root;
            while(currentItem!=null){
                if(currentItem.compareTo(listItem)<0) {
                    parentItem = currentItem;
                    currentItem = currentItem.next();
                }else if(currentItem.compareTo(listItem)>0){
                    parentItem=currentItem;
                    currentItem=currentItem.previous();
                }else{
                    performRemoval(currentItem,parentItem);
                    return true;
                }
            }
        }
        return false;
    }



    //        -  performRemoval(), takes two ListItems, the item to be removed and its parent. It doesn't return anything and is declared as private. Call this method from removeItem() when the item is found.

    public void performRemoval(ListItem currentItem,ListItem parentItem)
    {
        if(currentItem.next() == null) {
            if(parentItem.next() == currentItem) {
                parentItem.setNext(currentItem.previous());
            }else if(parentItem.previous() == currentItem) {
                parentItem.setPrevious(currentItem.next());
            }else {
                this.root = currentItem.previous();
            }
        }else if(currentItem.previous() == null) {
            if(parentItem.next() == currentItem) {
                parentItem.setNext(currentItem.next());
            }else if(parentItem.previous() == currentItem) {
                parentItem.setPrevious(currentItem.next());
            }else {
                this.root = currentItem.next();
            }
        }else {
            ListItem current = currentItem.next();
            ListItem leftmostParent = currentItem;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            currentItem.setValue(current.getValue());
            if(leftmostParent == currentItem) {
                currentItem.setNext(current.next());
            }else {
                leftmostParent.setPrevious(current.next());
            }
        }
    }
    //        -  traverse(), takes the root as an argument and does not return anything. It uses recursion to visit all the branches in the tree (Inorder). Print each value on a seperate line.
    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
