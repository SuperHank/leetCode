package solved.easy;

import java.util.LinkedList;

/**
 * [682] 棒球比赛
 * https://leetcode-cn.com/problems/baseball-game/
 */
public class CalPoints {
    public int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
        for (String op : ops) {

            switch (op) {
                case "C":
                    list.removeLast();
                    break;
                case "D":
                    Integer last = list.getLast();
                    list.addLast(last * 2);
                    break;
                case "+":
                    Integer add = list.getLast();
                    Integer second = list.get(list.size() - 2);
                    list.addLast(add + second);
                    break;
                default:
                    list.addLast(Integer.parseInt(op));
            }
        }


        int result = 0;
        for (Integer integer : list) {
            result += integer;
        }
        return result;
    }
}
