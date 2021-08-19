package attempted;

import java.util.LinkedList;

/**
 * [10] 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class IsMatch {

    public static void main(String[] args) {
        System.out.println(new IsMatch().isMatch("aa", "a"));
        System.out.println(new IsMatch().isMatch("aa", "a*"));
        System.out.println(new IsMatch().isMatch("ab", ".*"));
        System.out.println(new IsMatch().isMatch("aab", "c*a*b"));
        System.out.println(new IsMatch().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new IsMatch().isMatch("mississippi", "mis*is*ip*."));
        System.out.println(new IsMatch().isMatch("aaa", "ab*a*c*a"));
        System.out.println(new IsMatch().isMatch("aaa", ".*"));
        System.out.println(new IsMatch().isMatch("baaa", "b.*"));
        System.out.println(new IsMatch().isMatch("baaaa", "ba.*"));
        System.out.println(new IsMatch().isMatch("aaaa", "ab*a*c*a"));
    }

    public boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        LinkedList<Character> contentList = new LinkedList<>();
        for (char content : sArr) {
            contentList.addFirst(content);
        }

        char[] pArr = p.toCharArray();
        LinkedList<Character> parseList = new LinkedList<>();
        for (char parse : pArr) {
            parseList.addFirst(parse);
        }

        Character lastValidChar = null;
        while (!parseList.isEmpty()) {
            Character parseContent = parseList.removeFirst();
            switch (parseContent) {
                case '.':
                    if (contentList.isEmpty()) {
                        return false;
                    }
                    contentList.removeFirst();
                    break;
                case '*':
                    Character parse = parseList.removeFirst();
                    if (parse == '.') {
                        if (!contentList.isEmpty()) {
                            contentList.removeFirst();
                        }
                        Character content = null;
                        while (!contentList.isEmpty()) {
                            if (content == null) {
                                content = contentList.removeFirst();
                                lastValidChar = content;
                                continue;
                            }
                            if (contentList.getFirst() == content) {
                                contentList.removeFirst();
                            } else {
                                break;
                            }
                        }
                    } else {
                        while (!contentList.isEmpty()) {
                            if (contentList.getFirst() == parse) {
                                contentList.removeFirst();
                                lastValidChar = parse;
                            } else {
                                break;
                            }
                        }
                    }
                    break;
                default:
                    if (contentList.isEmpty()) {
                        if (parseContent == lastValidChar) {
                            break;
                        } else {
                            return false;
                        }
                    }
                    Character content = contentList.getFirst();
                    if (parseContent != content) {
                        if (parseContent != lastValidChar) {
                            return false;
                        } else {
                            contentList.removeFirst();
                        }
                    }
                    break;
            }
        }

        if (!contentList.isEmpty()) {
            for (Character character : contentList) {
                if (character != lastValidChar) {
                    return false;
                }
            }
        }
        return true;
    }
}
