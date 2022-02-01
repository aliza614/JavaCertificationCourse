import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Monster implements ISaveable{
    //3.  Monster (class)
    //
    //    -  It has three fields. One String called name and Two ints called hitPoints and strength.
    private String name;
    private int hitPoints;
    private int strength;
    //    -  A constructor that accepts a String (name) and two ints (hitPoints and strength). It initialises name, hitPoints and strength with the newly passed in values.

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    //    -  And six methods:
    //
    //                    -  Only getters for the three fields.

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    //        -  write(), same as interface. Return a List of the fields in the order they appear in toString().

    @Override
    public List<String> write() {
        List<String> list=new ArrayList<String>();
        list.add(name);
        list.add(""+hitPoints);
        list.add(""+strength);
        return list;
    }

    //                    -  read(), same as interface. Store the values in the List, in the order they appear in toString(). Make sure the List is not null and the size() is greater than 0 before storing the values.

    @Override
    public void read(List<String> list) {
        if(list!=null&&list.size()>0)
        {
            Iterator<String> iterator=list.iterator();
            this.name = iterator.next();
            this.hitPoints = Integer.parseInt(iterator.next());
            this.strength = Integer.parseInt(iterator.next());

        }
    }

    //                    -  toString(), Monsters overriding toString() method. It takes no arguments and returns a String in the following format:

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }

    //    Monster{name='Werewolf', hitPoints=20, strength=40}
}
