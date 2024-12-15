import java.util.HashSet;
import java.util.Iterator;

public class Hash_Set {
    public static void main(String[] args) {

        //Creating a HashSet
        HashSet<Integer> set=new HashSet<>();

        //Inserting elements in HashSet
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        //Displaying
        System.out.println(set);

        //Size of set
        System.out.println(set.size());

        //Deleting
        set.remove(3);
        System.out.println(set);
        set.add(7);

        //Iterator
        Iterator it=set.iterator();
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.hasNext());

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
