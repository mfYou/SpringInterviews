package ByteDance;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sn  = new Scanner(System.in);
        int n = sn.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = sn.nextInt();
        }
        System.out.println(getJudge(nums));
    }

    static int getJudge(int[] nums){
        int judge = 0;
        switch (nums.length){
            case 0:
                break;
            case 1:
                if (nums[0]<128&&nums[0]>0)
                    judge =1;
                break;
            case 2:
                if (nums[0]>=128&&nums[0]<192)
                    judge=1;
                break;
            case 3:
                if (nums[0]>=192&&nums[0]<256&&nums[1]>=128&&nums[1]<256)
                    judge=1;
                break;
        }
        return judge;
    }
}
