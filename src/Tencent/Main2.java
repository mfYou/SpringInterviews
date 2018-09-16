package Tencent;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int[] nums = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            nums[i] = sn.nextInt();
            if (nums[i] == 1) list.add(i);
        }
        int result = 1;
        for (int i=0; i<list.size()-1; i++){
            result*=(list.get(i+1)-list.get(i));
        }
        System.out.println(result);
    }
}
