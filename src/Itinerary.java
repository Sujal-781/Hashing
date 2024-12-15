import java.util.*;
public class Itinerary {

    public static String[] itinerary(String[] from,String[] to){
        String[] ans=new String[from.length+1];
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<from.length;i++){
            map.put(from[i],to[i]);
        }
        String start="";
        for(int i=0;i<from.length;i++){
            int k=0;
            for(int j=0;j<to.length;j++){
                if(from[i].equals(to[j])){
                    k++;
                    break;
                }
            }
            if(k==0){
                start=from[i];
                break;
            }
        }
        ans[0]=start;
        for(int i=1;i<ans.length;i++){
            ans[i]=map.get(ans[i-1]);
        }
        return ans;
    }
    public static void main(String[] args) {
        String from[]={"Chennai","Mumbai","Goa","Delhi"};
        String to[]={"Bengaluru","Delhi","Chennai","Goa"};
        System.out.println(Arrays.toString(itinerary(from,to)));
    }
}
//If input is given as a hashmap, make a reverse hashmap to search for start