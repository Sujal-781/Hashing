import java.util.*;
public class Hash_Map {
    public static void main(String[] args) {

        //Creating  a HashMap
        HashMap<String,String> map=new HashMap<>();

        //Insertion
        map.put("23BCS112","Subhash");
        map.put("23BCS113","Sujal");
        map.put("23BCS114","Tanishk");
        map.put("23BCS115","Tanishka");
        System.out.println(map);

        //Overriding a key
        map.put("23BCS115","Tanishq");  //value of already existing key is updated
        System.out.println(map);

        //Searching

        System.out.println(map.containsKey("23BCS113"));
        System.out.println(map.containsKey("23BCS107"));

        System.out.println(map.get("23BCS113"));
        System.out.println(map.get("23BCS107"));

        //Iteration - Method 1

        for(Map.Entry<String,String> e:map.entrySet()){
            System.out.println(e.getKey()+" -> "+e.getValue());
        }

        //Iteration Method 2

        Set<String> keys=map.keySet();
        for(String key:keys){
            System.out.println(key+" -> "+map.get(key));
        }


        //Deletion
        map.remove("23BCS114");
        System.out.println(map);
    }
}
