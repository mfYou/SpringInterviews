package Baicizhan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * String格式的JSON转为json格式，并根据key搜索
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String str = sn.nextLine();
        String key = sn.nextLine();
        BCON bcon = parseBCON(str);
        System.out.println(bcon.get(key));
    }

    private static BCON parseBCON(String str){
        BCON bcon = new BCON();
        String str1 = str.substring(str.indexOf("{"), str.lastIndexOf("}"));
        String[] arr1 = str1.split(";");
        for (int i=0; i<arr1.length; i++){
            String[] temp = arr1[i].split("->");
            bcon.put(temp[0].substring(0, temp[0].length()-1), temp[1].substring(0, temp[1].length()-1));
        }
        return bcon;
    }
    static class BCON{
        HashMap<String, Object> map;
        BCON(){
            map = new HashMap<>();
        }
        public void put(String key, Object value){
            map.put(key, value);
        }
        public Object get(String key){
            return map.get(key);
        }
    }
}
