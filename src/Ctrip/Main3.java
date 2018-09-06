package Ctrip;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n=sn.nextInt();
        LruCache cache = new LruCache(n);
        while (sn.hasNext()){
            String str = sn.nextLine();
            String[] arr = str.split(" ");
            System.out.println(Arrays.toString(arr));
            if (arr[0] == "p"){
                int key = Integer.parseInt(arr[1]);
                int value = Integer.parseInt(arr[2]);
                Node node = new Node(key, value);
                cache.put(node);
            }
            if (arr[0] == "g"){
                System.out.println(cache.get(Integer.parseInt(arr[1])));
            }
        }
    }



}

class LruCache{
    Node[] array;
    public LruCache(int n){
        array = new Node[n];
    }

    public Integer get(int key){
        for (int i=0; i<array.length; i++){
            if (array[i].getKey()==key){
                Node temp = array[i];
                for (int j = i; j>0; j--){
                    array[j] = array[j-1];
                }
                array[0] = temp;
                return temp.getValue();
            }
        }
        return null;
    }

    public void put(Node node){
        int i =0;
        while (i<array.length){
            if (array[i].getKey() == node.getKey()){
                for (int j=i; j>0; j--){
                    array[j] = array[j-1];
                }
                array[0] = node;
                return;
            }
            i++;
        }
        for (int j =array.length-1; j>0;j--){
            array[j] = array[j-1];
        }
        array[0] = node;
    }
}

class Node{
    public int key;
    public int value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
    public int getKey(){
        return this.key;
    }
    public int getValue(){
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
