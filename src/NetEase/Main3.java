package NetEase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sn.hasNextLine()){
            String temp = sn.nextLine();
            if (temp==null) break;
            list.add(temp);
        }
        double[][] x = new double[list.size()][];
        double[] y = new double[list.size()];
        for (int i=0; i<list.size(); i++){
            String[] strings = list.get(i).split(",");
            for (int j=0; j<strings.length-1; j++){
                x[i][j] = Double.parseDouble(strings[j]);
            }
            y[i] = Double.parseDouble(strings[strings.length-1]);
        }
        double[] solve = solve(x, y);
        String result = null;
        for (int i=0; i<solve.length; i++){
            if (result == null){
                result=String.valueOf((double)Math.round(solve[i]*100)/100);
            }else {
                result+=String.valueOf((double)Math.round(solve[i]*100)/100);
            }
        }
        System.out.println(result);
    }

    private static double[] solve(double[][] a, double[] b){
        if (a == null || b == null || a.length == 0 || a.length != b.length) {
            return null;
        }
        for (double[] x : a) {
            if (x == null || x.length != a.length)
                return null;
        }

        int len = a.length - 1;
        double[] result = new double[a.length];
        if (len == 0) {
            result[0] = b[0] / a[0][0];
            return result;
        }

        double[][] aa = new double[len][len];
        double[] bb = new double[len];
        int posx = -1, posy = -1;
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++)
                if (a[i][j] != 0.0d) {
                posy = j;
                break;
            }
            if (posy != -1) {
                posx = i;
                break;
            }
        }
        if (posx == -1) {
            return null;
        }

        int count = 0;
        for (int i = 0; i <= len; i++) {
            if (i == posx) {
                continue;
            }
            bb[count] = b[i] * a[posx][posy] - b[posx] * a[i][posy];
            int count2 = 0;
            for (int j = 0; j <= len; j++) {
                if (j == posy) {
                    continue;
                }
                aa[count][count2] = a[i][j] * a[posx][posy] - a[posx][j] * a[i][posy];
                count2++;
            }
            count++;
        }
        double[] result2 = solve(aa, bb);
        double sum = b[posx];
        count = 0;
        for (int i = 0; i <= len; i++) {
            if (i == posy) {
                continue;
            }
            sum -= a[posx][i] * result2[count];
            result[i] = result2[count];
            count++;
        }
        result[posy] = sum / a[posx][posy];
        return result;
    }
}
