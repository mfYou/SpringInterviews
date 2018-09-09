package ByteDance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String string = sn.nextLine();
        char[] array = string.toCharArray();
        int max = getMaxSeq(array);
        System.out.println(max);
    }
    static int getMaxSeq(char[] array){
        if (array.length<=0) return 0;
        Map<Character, Boolean> map = new HashMap<>();
        int start =0, end =0;
        int count = 0;
        int max =0;
        while (end<array.length){
            if (start == end){
                map.put(array[start], true);
                end++;
                count = 1;
            }else{
                if (map.get(array[end])!=null){
                    map.remove(array[end]);
                    count--;
                    start++;
                }else{
                    map.put(array[end],true);
                    end++;
                    count++;
                }
            }
            if (count>max){
                max = count;
            }
        }
        return max;
    }
}
