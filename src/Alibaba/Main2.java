package Alibaba;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

/**
 * 小广附近有家盒马店，该店提供配送服务，配送范围是系统根据各项指标决策出的一个多边形，
 * 假设小广现在的位置为（x,y），请问小广是否在该盒马店的配送范围内，如果不在配送范围内
 * 请问他要最少要走多少距离才能到盒马店配送范围内。假设坐标点在二维平面上，不考虑地球曲
 * 率等因素。
 *
 *
 *
 * 输入：
 *
 * x,y(代表小广所在的位置，x表示横坐标，y表示纵坐标)
 *
 * x1,y1,x2,y2,x3,y3....xn,yn(代表该盒马店的配送范围多边形，
 * 其中x表示横坐标，y表示纵坐标，xi和yi代表多边形一个点，点与点按顺序相连形成边，
 * 并且最后一个点(xn,yn)与第一个点(x1,y1)相连）
 *
 * 输出：
 *
 * 请问小广是否在盒马店的配送范围内，如果不在配送范围内请问他要最少走多少距离才能
 * 到盒马店配送范围内，输出结果为整数（四舍五入）
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String tmp1 = sn.nextLine();
        String tmp2 = sn.nextLine();
        String[] tmp3 = tmp1.split(",");
        String[] tmp4 = tmp2.split(",");
        Point start = new Point(Integer.parseInt(tmp3[0]),Integer.parseInt(tmp3[1]));
        List<Point> points = new ArrayList<>();
        for (int i=0; i<tmp4.length; i+=2){
            Point point = new Point(Integer.parseInt(tmp4[i]), Integer.parseInt(tmp4[i+1]));
            points.add(point);
        }
        if (isInShape(points,start)) System.out.println("yes,"+0);
    }

    private static boolean isInShape(List<Point> points, Point start){
        for (int i=0; i<points.size(); i++){
            if (start.equals(points.get(i))) return true;
            for (int j=i+1; j<points.size(); j++){
                if ((start.x-points.get(i).x)*(points.get(j).y - start.y) == (points.get(j).x-start.x)*(start.y-points.get(i).y)) return true;
            }

        }
        return false;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
