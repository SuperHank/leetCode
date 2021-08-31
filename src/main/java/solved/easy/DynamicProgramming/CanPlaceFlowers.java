package solved.easy.DynamicProgramming;

/**
 * [605] 种花问题
 * https://leetcode-cn.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 0, 1}, 1));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 0, 1}, 2));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 0}, 1));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 0}, 2));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 1}, 1));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 0, 0}, 1));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 0, 0}, 2));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 0, 0}, 3));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                // 左边不为1
                boolean left = false;
                if (i - 1 < 0) {
                    left = true;
                } else {
                    left = flowerbed[i - 1] == 0;
                }
                // 右边不为1
                boolean right = false;
                if (i + 1 >= flowerbed.length) {
                    right = true;
                } else {
                    right = flowerbed[i + 1] == 0;
                }

                if (left && right) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }
}
