package Baicizhan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List<String> list = new ArrayList<>();
        int i=0;
        for (int j=i; j<key.length();j++){
            if (key.charAt(j)=='.'){
                list.add(key.substring(i, j));
                i=j+1;
                j=i+1;
            }else if (j==key.length()-1){
                list.add(key.substring(i));
            }
        }
        for (int m=0; m<list.size()-1; m++){
            bcon=(BCON) bcon.get(list.get(m));
        }
        System.out.println(list.toString());
        System.out.println(bcon.get(list.get(list.size()-1)));
    }

    private static BCON parseBCON(String str){
        BCON bcon = new BCON();
        String str1 = str.substring(str.indexOf("{")+1, str.lastIndexOf("}"));
        int i =0;
        int len = str1.length();
        while (i<len){
            if (str1.charAt(i) == '"'){
                int j =i+1;
                int k_index = i;
                while (j<str1.length()&&str1.charAt(j)!='>'){
                    if (str1.charAt(j)=='"') k_index = j;
                    j++;
                }
                int m=j+1;
                int v_index=m+1;
                if (m<len&&str1.charAt(m)=='"'){
                    while (v_index<len&&str1.charAt(v_index)!='"') v_index++;
                    bcon.put(str1.substring(i+1,k_index),str1.substring(m+1,v_index));
                }else if (m<len&&str1.charAt(m)=='{'){
                    while (v_index<len&&str1.charAt(v_index)!='}') v_index++;
                    bcon.put(str1.substring(i+1, k_index), parseBCON(str1.substring(m,v_index+1)));
                }
                i=v_index+2;
            }else{
                i++;
            }
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

        @Override
        public String toString() {
            return map.toString();
        }
    }
}
