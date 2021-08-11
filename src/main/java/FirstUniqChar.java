import java.util.HashMap;

/**
 * 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("leetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {

        char[] chars = s.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], 1 + map.get(chars[i]));
            } else {
                map.put(chars[i], 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
