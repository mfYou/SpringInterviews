package Baicizhan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = sn.nextInt();
        }
        int i=0;
        int j=0;
        List<String> result = new ArrayList<>();
        while (i<n){
            j=i+1;
            while (j<n&&nums[j]-nums[j-1]==1){
                j++;
            }
            if (j-i>2){
                result.add(nums[i]+"-"+nums[j-1]);
                i=j;
            }else {
                for (int m =i; m<j; m++){
                    result.add(String.valueOf(nums[m]));
                }
                i=j;
            }
        }
        for (int m=0; m<result.size();m++){
            System.out.print(result.get(m));
            if (m<result.size()-1) System.out.print(" ");
        }
    }
}
