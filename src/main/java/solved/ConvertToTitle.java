package solved;

/**
 * [168] Excel表列名称
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        int mod;
        int x;
        char start = 'A' - 1;
        do {
            mod = columnNumber % 26;
            x = columnNumber / 26;

            if (mod > 0) {
                builder.append((char) (start + mod));
            } else {
                builder.append('Z');
                x--;
            }
            if (1 <= x && x <= 26) {
                builder.append((char) (start + x));
            }

            columnNumber = x;
        } while (x > 26);

        return builder.reverse().toString();
    }
}
