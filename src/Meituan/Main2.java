package Meituan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 小明拿到了一个数列a1 , a2 , ... an ，小明想知道存在多少个区间[l,r]同时满足下列两个条件：
 *
 * 1、r-l+1=k;
 *
 * 2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
 *
 * 输出满足条件的区间个数。
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String[] line1 = sn.nextLine().split(" ");
        int n=Integer.parseInt(line1[0]);
        int k=Integer.parseInt(line1[1]);
        int t=Integer.parseInt(line1[2]);
        int[] nums = new int[n];
        String[] line2 = sn.nextLine().split(" ");
        for (int i=0; i<n; i++){
            nums[i] = Integer.parseInt(line2[i]);
        }
        int num =0;
        for (int i=0; i<nums.length-k+1; i++){
            if (isTrue(nums, i, i+k-1, t)){
                num++;
            }
        }
        System.out.println(num);
    }

    private static boolean isTrue(int[] nums, int l, int r, int t){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=l; i<=r; i++){
            if (map.get(nums[i])!=null){
                int num = map.get(nums[i])+1;
                map.put(nums[i], num);
            }else {
                map.put(nums[i], 1);
            }
        }
        for (int i=l; i<=r; i++){
            if (map.get(nums[i])>=t){
                return true;
            }
        }
        return false;
    }
}
