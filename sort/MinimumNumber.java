import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Given a list of non negative integers, arrange them such that they form the smallest number.
 *
 * Created by Jiacheng on 2018/4/4.
 */
public class MinimumNumber {

    public String miniNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        String[] s_num = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            s_num[i] = String.valueOf(num[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        };
        Arrays.sort(s_num, comp);
        if (s_num[0].charAt(0) == '0') {
            String temp = s_num[0];
            s_num[0] = s_num[1];
            s_num[1] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : s_num) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String nums = num.trim().replace(" ", "");
        int[] index = new int[nums.length()];
        for (int i = 0; i < index.length; i++) {
            index[i] = nums.charAt(i) - '0';
        }
        String solution = new MinimumNumber().miniNumber(index);
        System.out.println("solution is " + solution);
    }
}
