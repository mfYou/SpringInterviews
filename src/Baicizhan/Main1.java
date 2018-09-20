package Baicizhan;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String str1 = sn.nextLine();
        String str2 = sn.nextLine();
        String[] arr1 = str1.split(":");
        String[] arr2 = str2.split(":");
        double[] start = new double[3];
        double[] end = new double[3];
        for (int i=0; i<3; i++){
            start[i] = Double.parseDouble(arr1[i]);
            end[i] = Double.parseDouble(arr2[i]);
        }
        if (start[0]>end[0]||(start[0]==end[0]&&start[1]>end[1])||(start[0]==end[0]&&start[1]==end[1]&&start[2]>end[2])){
            return;
        }
        double h = end[0]-start[0];
        double m = end[1]-start[1];
        double s = end[2]-start[2];
        double h_max = 12*60*60;
        double m_max = 60*60;
        double s_max = 60;
        double sum = h*60*60+m*60+s;
        System.out.println(new Double(Math.floor(sum/h_max*360)).intValue());
        System.out.println(new Double(Math.floor(sum/m_max*360)).intValue());
        System.out.println(new Double(Math.floor(sum/s_max*360)).intValue());
    }
}
