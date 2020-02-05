package algorithm;

public class LargestTriangleArea {
    //计算一个数组点所能组成的最大三角形的面积
    /**
     * 方法一：二维直角坐标系下面积计算公式
     * A(X1,Y1)B(X2,Y2)C(X3,Y3)/C(X3,Y3)B(X2,Y2)A(X1,Y1)
     * S=1/2*(X1Y2+X2Y3+X3Y1-X3Y2-X2Y1-X1Y3)
     */
    public double largestTriangleArea(int[][] points) {
        int length = points.length;
        double result = 0.0;
        for(int i = 0;i < length;++i){
            for(int j = i+1;j < length;++j){
                for(int k = j+1;j < length;++j){
                    result = Math.max(result,area(points[i],points[j],points[k]));
                }
            }
        }
        return result;
    }
    private double area(int[] a,int[] b,int[] c){
        return 0.5*Math.abs(a[0]*b[1] + b[0]*c[1] + c[0]*a[1] - c[0]*b[1] - b[0]*a[1] - a[0]*c[1]);
    }
}
