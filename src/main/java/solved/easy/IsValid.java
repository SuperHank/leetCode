package solved.easy;


import java.util.Stack;

/**
 * [20] 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("()"));
        System.out.println(new IsValid().isValid("()[]{}"));
        System.out.println(new IsValid().isValid("(}"));
        System.out.println(new IsValid().isValid("([)]"));
        System.out.println(new IsValid().isValid("{[]}"));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '(' && aChar != ')') {
                    return false;
                }
                if (pop == '[' && aChar != ']') {
                    return false;
                }
                if (pop == '{' && aChar != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
