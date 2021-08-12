package solved.easy;

/**
 * [844] 比较含退格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        while (s.contains("#")) {
            int index = s.indexOf("#");
            if (index == 0) {
                s = s.substring(1);
            } else {
                s = s.substring(0, index - 1) + s.substring(index + 1);
            }
        }

        while (t.contains("#")) {
            int index = t.indexOf("#");
            if (index == 0) {
                t = t.substring(1);
            } else {
                t = t.substring(0, index - 1) + t.substring(index + 1);
            }
        }

        return s.equals(t);

    }
}
