package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. Split Array into Fibonacci Sequence
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/description/
 */
public class FibonacciSequence {
    private ArrayList<Integer> result;
    private char[] sc;
    public List<Integer> splitIntoFibonacci(String S) {
        result = new ArrayList<>();
        sc = S.toCharArray();
        int n = sc.length;
        int fi = 0,fi1 = 0,fi2 = 0,l1 = 0,l2 = 0,l3 = 0;
        for(int i = 0;i < (n/2);++i){
            //求fi
            for(int i1 = 0;i1 <= i;++i1){
                fi = fi * (int)Math.pow(10,i1) + (sc[i1] - '0');
            }
            l1 = i+1;
            //求fi1
            for(int j = i+1;j < (n-l1)/2;++j){
                fi1 = fi1 * (int)Math.pow(10,j-(i+1)) + (sc[j] - '0');
                l2 = j - (i+1) + 1;
                l3 = Math.max(l1,l2);
                if(n - l1 - l2 < l3)continue;
                else{
                    //不产生进位，相等，继续递归查找
                    //不产生进位，不相等，按照产生进位查找
                    //产生进位，相等，继续递归查找
                    //产生进位，不相等，继续前面，更换fi或fi1
                    //n-l1-l2 == l3不产生进位，2位+2位=2位
                    //求fi2
                    for(int k = j+1,time = 0;time < l3;++time,++k){
                        fi2 = fi2 * (int)Math.pow(10, k - (j+1)) + (sc[k]-'0');
                    }
                    if(fi + fi1 == fi2){
                        //如果在这里把fi和fi1加进去，如果后续没找到，则要弹出，对
                        result.add(fi);
                        result.add(fi1);
                        result.add(fi2);
                        return fab(fi1,l2,fi2,l3,j+1+l3,sc,n);
                    }else{
                        fi2 = 0;
                        for(int k = j+1,time = 0;time < l3+1;++time,++k){
                            fi2 = fi2 * (int)Math.pow(10, k - (j+1)) + (sc[k]-'0');
                        }
                        if(fi + fi1 == fi2){
                            result.add(fi);
                            result.add(fi1);
                            result.add(fi2);
                            return fab(fi1,l2,fi2,l3,j+1+l3+1,sc,n);
                        }else continue;
                    }
                }
            }
        }
        //执行完毕没有返回满足条件的数列，则返回空
        return result;
    }

    private List<Integer> fab(int fi,int l1,int fi1,int l2,int fi2StartIdx,char[] sc,int n){
        int l3 = Math.max(l1,l2);
        int fi2 = 0;
        if(fi2StartIdx >= n)return result;
        else if(fi2StartIdx < n && (n-fi2StartIdx) >= l3){
            //有可能存在
            for(int i = fi2StartIdx,time = 0;time < l3;i++,time++){
                fi2 = fi2 * (int)Math.pow(10,(i-fi2StartIdx)) + (sc[i] - '0');
            }
            if(fi + fi1 == fi2){
                result.add(fi2);
                return fab(fi1,l2,fi2,l3,fi2StartIdx+l3,sc,n);
            }else{
                //进位这个可以有优化的地方，比如如果2+3>4，就不可能产生进位，所以也没必要执行下面的语句
                //可能有进位，两位加两位 = 三位
                fi2 = 0;
                for(int i = fi2StartIdx,time = 0;time < l3+1;i++,time++){
                    fi2 = fi2 * (int)Math.pow(10,(i-fi2StartIdx)) + (sc[i] - '0');
                }
                if(fi + fi1 == fi2){
                    result.add(fi2);
                    return fab(fi1,l2,fi2,l3,fi2StartIdx+l3+1,sc,n);
                }else{return new ArrayList<>();}
            }
        }else{
            //(n-fi2StartIdx) < l3 --无法找到f（i+2），那这个时候回到上层还能找到吗
            int size = result.size();
            if(size >= 3){
                result.remove(size-1);
                result.remove(size-2);
                result.remove(size-3);
            }
            return result;

        }
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciSequence().splitIntoFibonacci("123456579"));
    }
}
