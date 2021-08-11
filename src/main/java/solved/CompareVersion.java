package solved;

/**
 * [165] 比较版本号
 * https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");


        int maxLength = Math.max(version1Arr.length, version2Arr.length);

        for (int i = 0; i < maxLength; i++) {
            int subVersion1 = 0;
            if (i < version1Arr.length) {
                subVersion1 = Integer.parseInt(version1Arr[i]);
            }

            int subVersion2 = 0;
            if (i < version2Arr.length) {
                subVersion2 = Integer.parseInt(version2Arr[i]);
            }

            if (subVersion1 > subVersion2) {
                return 1;
            } else if (subVersion1 < subVersion2) {
                return -1;
            }
        }
        return 0;
    }
}

