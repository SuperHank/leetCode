package solved.medium.BackTracking;

import java.util.*;

/**
 * [17] 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
        System.out.println(new LetterCombinations().letterCombinations(""));
        System.out.println(new LetterCombinations().letterCombinations("2"));
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        char[] charArray = digits.toCharArray();

        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        backTracking(map, charArray, 1, 0, path, res);
        return res;
    }

    private void backTracking(HashMap<Character, List<String>> map, char[] charArray, int startIndex, int contentIndex, LinkedList<String> path, List<String> res) {
        if (path.size() == charArray.length) {
            res.add(String.join("", path));
            return;
        }

        if (startIndex - 1 > map.size() - 1) {
            return;
        }

        if (startIndex - 1 > charArray.length - 1) {
            return;
        }

        List<String> list = map.get(charArray[startIndex - 1]);
        if (list == null) {
            return;
        }

        for (int i = contentIndex; i < list.size(); i++) {
            path.addLast(list.get(i));
            backTracking(map, charArray, startIndex + 1, contentIndex, path, res);
            path.removeLast();
        }
        startIndex++;
    }
}
