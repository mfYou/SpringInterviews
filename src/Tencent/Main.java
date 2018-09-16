package Tencent;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String string = sn.next();
        String target = sn.next();
        char[] array = string.toCharArray();
        char[] targets = target.toCharArray();
        System.out.println(getLength(array,targets));
    }

    private static int getLength(char[] array, char[] targets){
        List<Integer> list = new ArrayList<>();
        for (int i =0; i<array.length; i++){
            int j=0;
            if (array[i] == targets[j]){
                while (j<targets.length&&i+j<array.length&&array[i+j]==targets[j]){
                    j++;
                }
                if (j==targets.length){
                    for (int k=0; k<targets.length; k++){
                        list.add(i+k);
                    }
                }
            }
        }
        if (list.size()==0) return 0;
        Collections.sort(list);
        int result = 0;
        int len = 0;
        for (int i=0; i<list.size(); i++){
            if (i == 0){
                len=1;
            }else if ((list.get(i) - list.get(i-1))>1){
                result += len*len;
                len = 1;
            }else if (list.get(i)-list.get(i-1)==1){
                len+=1;
            }
        }
        result+=len*len;
        return result;
    }
}
