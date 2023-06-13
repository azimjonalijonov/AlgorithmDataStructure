public class LongestCommonSubsequenceRecursiveSolution {

    public static int longestCommonSubsequence(String text1, String text2) {
        return lcsHelper(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    private static int lcsHelper(String text1, String text2, int i, int j) {
        // Base case: if either string is empty, return 0
        if (i < 0 || j < 0) {
            return 0;
        }

        // If the last characters of both strings match, recursively find LCS of the remaining strings
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + lcsHelper(text1, text2, i - 1, j - 1);
        }

        // If the last characters don't match, consider two possibilities:
        // 1. Exclude the last character of text1 and find LCS of the remaining strings
        // 2. Exclude the last character of text2 and find LCS of the remaining strings
        else {
            return Math.max(lcsHelper(text1, text2, i - 1, j), lcsHelper(text1, text2, i, j - 1));
        }
    }

    public static void main(String[] args) {
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";
        int lcsLength = longestCommonSubsequence(text1, text2);
        System.out.println("Length of Longest Common Subsequence: " + lcsLength);
    }
}

