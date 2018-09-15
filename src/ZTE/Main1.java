package ZTE;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        int num = 10;
        int[] salaries = {20,40,26,25,40,20,40,20,40,25};
        System.out.println(salaryFrequency(num, salaries).toString());
    }

    static List<Integer> salaryFrequency(int num, int[] salaries){
        Arrays.sort(salaries);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        int count = 0;
        while (end<salaries.length){
            if (start==end){
                end++;
                count = 1;
                map.put(salaries[start],count);
            }else if (salaries[end]==salaries[start]){
                end++;
                count++;
                map.put(salaries[start], count);
            }else {
                start = end;
                end++;
                count = 1;
                map.put(salaries[start], count);
            }
        }
        System.out.println(map.toString());
        while (!map.isEmpty()){
            int max = 0;
            int index = 0;
            for (Integer key:map.keySet()){
                if (map.get(key) > max){
                    max = map.get(key);
                    index = key;
                }
            }
            for (int i=0; i<max; i++){
                list.add(index);
            }
            map.remove(index);
        }
        return list;
    }
}
