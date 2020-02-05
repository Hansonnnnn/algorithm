package algorithm.exam.three;

import java.util.*;

/*In a given cartesian plane, there are N points. We need to find the Number of Pairs of points(A,B) such that

Point A and Point B do not coincide.
Manhattan Distance and the Euclidean Distance between the points should be equal.
Note : Pair of 2 points(A,B) is considered same as Pair of 2 points(B,A).

Manhattan Distance = |x2-x1|+|y2-y1|

Euclidean Distance = ((x2-x1)^2 + (y2-y1)^2)^0.5 where points are (x1,y1) and (x2,y2).
*/
public class DistanceProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = Integer.valueOf(scanner.nextLine());
        while(testNum>0) {
            int pointsNum = Integer.valueOf(scanner.nextLine());
            Map<Integer, Integer> xMap = new HashMap<>();
            Map<Integer, Integer> yMap = new HashMap<>();
            Map<String, Integer> xyMap = new HashMap<>();
            while(pointsNum > 0) {
                String[] xy = scanner.nextLine().split(" ");
                int x = Integer.valueOf(xy[0]);
                xMap.put(x, xMap.getOrDefault(x, 0)+1);
                int y = Integer.valueOf(xy[1]);
                yMap.put(y, yMap.getOrDefault(y, 0)+1);
                String pair = x + " " + y;
                xyMap.put(pair, xyMap.getOrDefault(pair, 0));
                pointsNum--;
            }
            int x_ans =0;
            int y_ans =0;
            int xy_ans =0;
            for(int i : xMap.keySet()) {
                int d = xMap.get(i);
                x_ans += (d*(d-1))/2;
            }
            for(int i : yMap.keySet()) {
                int d = yMap.get(i);
                y_ans += (d*(d-1))/2;
            }
            for(String i : xyMap.keySet()) {
                int d = xyMap.get(i);
                xy_ans += (d*(d-1));
            }
            System.out.println(x_ans+y_ans-xy_ans);
            testNum--;
        }

    }

    /**
     * public static void main(String[] args) {
     *         Scanner scanner = new Scanner(System.in);
     *         int testNum = Integer.valueOf(scanner.nextLine());
     *         while(testNum>0) {
     *             int pointsNum = Integer.valueOf(scanner.nextLine());
     *             List<Point> list = new ArrayList<>();
     *             while(pointsNum > 0) {
     *                 String[] xy = scanner.nextLine().split(" ");
     *                 list.add(new Point(Integer.valueOf(xy[0]), Integer.valueOf(xy[1])));
     *                 pointsNum--;
     *             }
     *             int count = 0;
     *             for(int i = 0;i < list.size();i++) {
     *                 for(int j = i+1;j < list.size();j++) {
     *                     Point p1 = list.get(i);
     *                     Point p2 = list.get(j);
     *                     double md = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
     *                     double ed = Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
     *                     if(md == ed) {
     *                         count++;
     *                     }
     *                 }
     *             }
     *             System.out.println(count);
     *             testNum--;
     *         }
     *
     *     }
     */

    private static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
