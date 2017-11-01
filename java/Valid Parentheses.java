/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        String leftBracket = "([{";
        String rightBracket = ")]}";
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int index = leftBracket.indexOf((int) ch);
            if (index != -1) {//如果是左括号
                stack.push(ch);
            } else {//如果是右括号
                if (stack.empty() || stack.peek() != leftBracket.charAt(rightBracket.indexOf((int) ch))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.empty();
    }
}
