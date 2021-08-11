package solved;

import java.util.HashMap;

/**
 * [389] 找不同
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        HashMap<Character, Integer> smap = new HashMap<>();
        for (int i = 0; i < sArr.length; i++) {
            if (smap.containsKey(sArr[i])) {
                smap.put(sArr[i], smap.get(sArr[i]) + 1);
            } else {
                smap.put(sArr[i], 1);
            }
        }
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < tArr.length; i++) {
            if (tmap.containsKey(tArr[i])) {
                tmap.put(tArr[i], tmap.get(tArr[i]) + 1);
            } else {
                tmap.put(tArr[i], 1);
            }
        }

        Character result = null;
        for (Character character : tmap.keySet()) {
            if (!smap.containsKey(character)) {
                result = character;
                break;
            }
            if (smap.get(character) < tmap.get(character)) {
                result = character;
                break;
            }
        }
        return result;
    }
}
