import java.util.*;
import java.util.ArrayList;

//Union of two arrays question
public class Union {

    public static ArrayList<Integer> union(int[] arr1, int[] arr2){
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        Iterator it=set.iterator();
        while(it.hasNext()){
            list.add((int)it.next());
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr1={2,3,4,3,6,5,4};
        int[] arr2={0,7,5,3,5,0,2,3,4,5,999};
        ArrayList<Integer> arr=union(arr1,arr2);
        System.out.println(arr);
    }
}
