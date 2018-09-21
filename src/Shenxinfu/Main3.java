package Shenxinfu;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        double[][] nums = new double[n][6];
        for (int i=0; i<n; i++){
            nums[i][0] = sn.nextInt();
            nums[i][1] = sn.nextInt();
            nums[i][2] = sn.nextInt();
            nums[i][3] = sn.nextInt();
            nums[i][4] = sn.nextInt();
            nums[i][5] = sn.nextInt();
        }
        for (int i=0; i<n; i++){
            double a1 = nums[i][0];
            double b1 = nums[i][1];
            double v1 = nums[i][2];
            double a2 = nums[i][3];
            double b2 = nums[i][4];
            double v2 = nums[i][5];

            double x = (b1*v2/b2-v1)/(a2*b1/b2-a1);
            double y = (a1*v2/a2-v1)/(a1*b2/a2-b1);
            if (x>0&&Math.ceil(x)==Math.floor(x)&&y>0&&Math.ceil(y)==Math.floor(y)){
                int res_x = (int) x;
                int res_y = (int) y;
                System.out.println(res_x+" "+res_y);
            }else {
                System.out.println("UNKNOWN");
            }
        }
    }
}
