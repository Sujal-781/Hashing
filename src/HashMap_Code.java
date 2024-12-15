import java.util.*;
public class HashMap_Code {
    static class HashMap<K,V>{     //generics
        private class Node{
            K key;
            V value;

            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;   //n - Nodes
        private int N;   //N - Buckets
        private LinkedList<Node> buckets[];    //array buckets of type LinkedList

        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();  //Creating empty LL at every index of array
            }
        }

        private int hashFunction(K key){
            int bi=key.hashCode();  //should be in 0 to n-1
            return Math.abs(bi) % N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll=buckets[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key==key)
                    return i;    //di- data index
            }
            return -1;
        }

        //Rehashing

        private void rehash(){
            LinkedList<Node> oldbucket[]=buckets;
            buckets=new LinkedList[n*2];
            for(int i=0;i<N*2;i++){
                buckets[i]=new LinkedList<>();
            }
            for(int i=0;i<oldbucket.length;i++){
                LinkedList<Node> ll=oldbucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }

        public void put(K key,V value){
            //Calculate bucket index
            int bi=hashFunction(key);

            //go to this bucket index and check at every node if key exists or not
            int di=searchInLL(key,bi);  //di tells me index of particular key in LL

            if(di==-1){  //key doesn't exist
                buckets[bi].add(new Node(key,value));
                n++;
            }
            else{        //key already exists
                Node data=buckets[bi].get(di);
                data.value=value;
            }
            double lambda=(double)n/N;
            if(lambda>2.0){
                //Rehashing
                rehash();
            }
        }


        public V get(K key){
            //Calculate bucket index
            int bi=hashFunction(key);

            //go to this bucket index and check at every node if key exists or not
            int di=searchInLL(key,bi);  //di tells me index of particular key in LL

            if(di==-1){  //key doesn't exist
                return null;
            }
            else{        //key already exists
                Node node=buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key){
            //Calculate bucket index
            int bi=hashFunction(key);

            //go to this bucket index and check at every node if key exists or not
            int di=searchInLL(key,bi);  //di tells me index of particular key in LL

            if(di==-1){  //key doesn't exist
                return false;
            }
            else{        //key already exists
               return true;
            }
        }

        public V remove(K key){
            //Calculate bucket index
            int bi=hashFunction(key);

            //go to this bucket index and check at every node if key exists or not
            int di=searchInLL(key,bi);  //di tells me index of particular key in LL

            if(di==-1){  //key doesn't exist
                return null;
            }
            else{        //key already exists
                Node node=buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }
        public boolean isEmpty(){
            return n==0;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }
    public static void main(String args[]){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("India",190);
        map.put("China",200);
        map.put("USA",100);
        map.put("Canada",50);

        ArrayList<String> keys=map.keySet();
        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
        map.remove("India");
        System.out.println(map.get("India"));
    }
}
