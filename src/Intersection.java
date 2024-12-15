import java.util.*;
public class Intersection {

    public static int[] intersection(int[] arr1,int[] arr2){
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                set2.add(arr2[i]);
            }
        }
        int[] arr=new int[set.size()];
        Iterator it=set2.iterator();
        int i=0;
        while(it.hasNext()){
            arr[i++]=(int)it.next();
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr1={1,2,2,1};
        int[] arr2={2,2};
        int[] arr=intersection(arr1,arr2);
        System.out.println(Arrays.toString(arr));
    }
}
