/**
 * 014. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * Created by Jiacheng on 2018/3/6.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String solution = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(solution) == -1) {
                solution = solution.substring(0, solution.length() - 1);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        String[] romanNum = {"aaabv", "aaafc", "aaarr", "aaaqqq"};
        String solution = new LongestCommonPrefix().longestCommonPrefix(romanNum);
        System.out.println("solution is " + solution);
    }
}
