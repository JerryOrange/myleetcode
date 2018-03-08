/**
 * 028. Implement strStr()
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * to implement indexOf()
 * <p>
 * Created by Jiacheng on 2018/3/8.
 */
public class ImplementStr {
    public int strStr(String haystack, String needle) {
        if (haystack.indexOf(needle) == -1) {
            return -1;
        } else {
            return haystack.indexOf(needle);
        }
    }

    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public static void main(String[] args) {
        String haystack = "abc";
        String needle = "ba";
        int solution = new ImplementStr().strStr2(haystack, needle);
        System.out.println("solution is " + solution);
    }
}
