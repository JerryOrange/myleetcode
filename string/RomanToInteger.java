/**
 * 013. Roman to Integer
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Created by Jiacheng on 2018/3/6.
 */
public class RomanToInteger {

    /**
     * only scan string once
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int intRoman = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    intRoman += (intRoman >= 5 ? -1 : 1);
                    break;
                case 'V':
                    intRoman += 5;
                    break;
                case 'X':
                    intRoman += 10 * (intRoman >= 50 ? -1 : 1);
                    break;
                case 'L':
                    intRoman += 50;
                    break;
                case 'C':
                    intRoman += 100 * (intRoman >= 500 ? -1 : 1);
                    break;
                case 'D':
                    intRoman += 500;
                    break;
                case 'M':
                    intRoman += 1000;
                    break;
            }
        }
        return intRoman;
    }

    public int romanToInt2(String s) {
        int sum = 0;
        if (s.indexOf("IV") != -1) {
            sum -= 2;
        }
        if (s.indexOf("IX") != -1) {
            sum -= 2;
        }
        if (s.indexOf("XL") != -1) {
            sum -= 20;
        }
        if (s.indexOf("XC") != -1) {
            sum -= 20;
        }
        if (s.indexOf("CD") != -1) {
            sum -= 200;
        }
        if (s.indexOf("CM") != -1) {
            sum -= 200;
        }

        char c[] = s.toCharArray();
        int count = 0;

        for (; count <= s.length() - 1; count++) {
            if (c[count] == 'M') sum += 1000;
            if (c[count] == 'D') sum += 500;
            if (c[count] == 'C') sum += 100;
            if (c[count] == 'L') sum += 50;
            if (c[count] == 'X') sum += 10;
            if (c[count] == 'V') sum += 5;
            if (c[count] == 'I') sum += 1;

        }
        return sum;
    }

    public static void main(String[] args) {
        String romanNum = "";
        int solution = new RomanToInteger().romanToInt(romanNum);
        System.out.println("solution is " + solution);
    }
}
