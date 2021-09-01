package solved.medium.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [93] 复原IP地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("25525511135"));
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("0000"));
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("1111"));
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("010010"));
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("101023"));
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
    }

    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();

        LinkedList<String> path = new LinkedList<>();

        backTracking(s, 0, path, res);

        return res;
    }

    private void backTracking(String content, Integer startIndex, LinkedList<String> path, List<String> res) {
        if (path.size() == 4) {
            if (startIndex == content.length()) {
                res.add(String.join(".", path));
            }
            return;
        } else if (path.size() > 4) {
            return;
        }

        for (int i = startIndex; i < content.length(); i++) {
            String substring = content.substring(startIndex, i + 1);
            if (i + 1 - startIndex > 3) {
                return;
            }
            int value = Integer.parseInt(substring);
            if (substring.length() > 1 && (substring.startsWith("0") || value == 0)) {
                continue;
            }
            if (value <= 255L) {
                path.addLast(substring);
                backTracking(content, i + 1, path, res);
                path.removeLast();
            }
        }
    }
}

