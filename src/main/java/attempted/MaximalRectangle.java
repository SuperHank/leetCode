package attempted;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * [85] 最大矩形
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    public int maximalRectangle(char[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];


        // TODO
        return Integer.MIN_VALUE;
    }
}
