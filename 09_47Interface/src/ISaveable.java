import java.util.List;

public interface ISaveable {
    //1.  ISaveable (interface)
    //
    //    -  It has two methods:
    //
    //                    -  write(), takes no arguments and returns a List containing objects of type String.
   public List<String> write ();
    //                    -  read(), takes a List of type String and doesn't return anything.
    public void read(List<String> list)  ;
}
