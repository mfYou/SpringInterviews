package CMB;

/**
 * 找连加结果为n的数组
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int nums[] = new int[n];
        for (int i=0;i<n; i++){
            nums[i] = i+1;
        }
        int start = 0;
        int end = 0;
        int count = 0;
        while (count < n){
            count += nums[end];
            end++;
        }
        while (end < n){
            if (count > n){
                count -= nums[start];
                start ++;
            }else if (count < n){
                count+=nums[end];
                end++;
            }else{
                printArray(nums, start, end);
                count+=nums[end];
                end++;
            }
        }
    }

    private static void printArray(int[] nums, int start, int end){
        int[] tmp = new int[end-start+1];
        for (int i=0; i<tmp.length; i++){
            tmp[i] = nums[start+i];
        }
        System.out.print(Arrays.toString(tmp));
    }
}
