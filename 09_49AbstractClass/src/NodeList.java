public interface NodeList {
    //4.  NodeList (interface)
    //
    //    -  It has four methods:
    //
    //        -  getRoot(), addItem(), removeItem() and traverse() which are package-private and abstract (see child class for declaration).
    abstract ListItem getRoot();
    abstract boolean addItem(ListItem listItem);
    abstract boolean removeItem(ListItem listItem);
    abstract void traverse(ListItem root);

}
